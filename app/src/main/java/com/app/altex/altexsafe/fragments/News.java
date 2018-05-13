package com.app.altex.altexsafe.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;


import com.app.altex.altexsafe.R;
import com.app.altex.altexsafe.customelements.GridAdapter;
import com.app.altex.altexsafe.customelements.ImageGridItem;
import com.app.altex.altexsafe.thirdpatryactivity.NewsView;
import com.bluehomestudio.progresswindow.ProgressWindow;
import com.bluehomestudio.progresswindow.ProgressWindowConfiguration;
import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {

    GridView gv;
    private ProgressWindow progressWindow;
    private ArrayList<ImageGridItem> currentNewsSet = new ArrayList<>();

    public News() {
        // Required empty public constructor
    }

    public static ArrayList<ImageGridItem> news_items = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_news, container, false);
        progressConfigurations();
        progressWindow.showProgress();
        String urlString = "http://www.androidcentral.com/feed";
        gv = (GridView) result.findViewById(R.id.grid);
        Parser parser = new Parser();
        parser.execute(urlString);
        parser.onFinish(new Parser.OnTaskCompleted() {

            @Override
            public void onTaskCompleted(ArrayList<Article> list) {
                //what to do when the parsing is done
                //the Array List contains all article's data. For example you can use it for your adapter.
                news_items.clear();
                for (Article a: list){
                    if(a.getImage()!=null)
                    news_items.add(new ImageGridItem(a.getTitle(), a.getContent(), a.getImage()));
                }
                currentNewsSet = (ArrayList<ImageGridItem>)news_items.clone();
                gv.setAdapter(new GridAdapter(getContext(), news_items));
                progressWindow.hideProgress();
            }

            @Override
            public void onError() {
                //what to do in case of error
                progressWindow.hideProgress();
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(getContext(), NewsView.class);
                intent.putExtra("item", currentNewsSet.get(i));
                startActivity(intent);

            }
        });

        ((TextInputEditText)result.findViewById(R.id.news_search)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentNewsSet.clear();
                for (ImageGridItem i:news_items){
                    if (i.mName.contains(editable.toString())){
                        currentNewsSet.add(i);
                    }
                }

                ListAdapter adapter = new GridAdapter(getContext(), currentNewsSet);
                gv.setAdapter(adapter);
            }
        });

        return result;
    }


    private void progressConfigurations(){
        progressWindow = ProgressWindow.getInstance(getContext());
        ProgressWindowConfiguration progressWindowConfiguration = new ProgressWindowConfiguration();
        progressWindowConfiguration.backgroundColor = Color.parseColor("#32000000") ;
        progressWindowConfiguration.progressColor = Color.WHITE ;
        progressWindow.setConfiguration(progressWindowConfiguration);
    }
}
