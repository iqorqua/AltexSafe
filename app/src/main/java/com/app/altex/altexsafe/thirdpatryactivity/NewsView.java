package com.app.altex.altexsafe.thirdpatryactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.altex.altexsafe.R;
import com.app.altex.altexsafe.customelements.ImageGridItem;
import com.squareup.picasso.Picasso;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;


public class NewsView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_view);
        ImageGridItem item = (ImageGridItem) getIntent().getExtras().getSerializable("item");

        Picasso.get().load(item.getImage()).into((ImageView)findViewById(R.id.news_image_preview));
        ((TextView)findViewById(R.id.news_txt_head)).setText(item.getName());
        HtmlTextView htmlTextView = (HtmlTextView) findViewById(R.id.news_content);
        htmlTextView.setHtml(item.getContent(), new HtmlAssetsImageGetter(htmlTextView));
    }
}
