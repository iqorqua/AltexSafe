package com.app.altex.altexsafe.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.app.altex.altexsafe.R;
import com.app.altex.altexsafe.customelements.RefilItem;
import com.app.altex.altexsafe.customelements.RefilItemAdapter;
import com.app.altex.altexsafe.customelements.WalletItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Refil extends Fragment {


    public Refil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RefilItem ref = new RefilItem("","","");
        View result = inflater.inflate(R.layout.fragment_refil, container, false);
        ArrayList<RefilItem> aray = new ArrayList<>();
        aray.add(ref);
        ListAdapter adapter = new RefilItemAdapter(aray);
        ((ListView)result.findViewById(R.id.refil_listview)).setAdapter(adapter);
        return result;
    }

}
