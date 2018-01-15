package com.codekul.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BtnPnl extends Fragment {


    public BtnPnl() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View viewInf = inflater.inflate(R.layout.fragment_btn_pnl, container, false);
        final MainActivity hstAct = (MainActivity) getActivity();

        viewInf.findViewById(R.id.btnBike).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hstAct.loadFrg(new BikeFragment());
            }
        });

        viewInf.findViewById(R.id.btnPlane).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hstAct.loadFrg(new PlaneFragment());
            }
        });

        viewInf.findViewById(R.id.btnBus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hstAct.loadFrg(new RailFragment());
            }
        });

        return viewInf;
    }
}
