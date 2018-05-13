package com.app.altex.altexsafe.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.altex.altexsafe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Withdraw extends Fragment {


    public Withdraw() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_withdraw, container, false);
        final TextView amount_edit = result.findViewById(R.id.withdraw_amount_edit);
                result.findViewById(R.id.withdraw_btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(amount_edit.getText().toString().equals("")){
                    Toast.makeText(view.getContext(), "Address is empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return result;
    }

}
