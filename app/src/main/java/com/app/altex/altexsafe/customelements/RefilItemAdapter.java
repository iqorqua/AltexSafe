package com.app.altex.altexsafe.customelements;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.altex.altexsafe.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by igorqua on 17.03.2018.
 */

public class RefilItemAdapter extends BaseAdapter {
    ArrayList<RefilItem> objects;
    public RefilItemAdapter( ArrayList<RefilItem> items){
        objects = items;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_refil, null);
    }
    WalletItem getWallettItem(int position) {
        return ((WalletItem) getItem(position));
    }

}
