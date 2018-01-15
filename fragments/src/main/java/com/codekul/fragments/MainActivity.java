package com.codekul.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFrg(new BtnPnl());
    }

    public void loadFrg(Fragment frag) {
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction txn = mgr.beginTransaction();
        txn.replace(R.id.frmCont, frag);
        txn.commit();
    }
}
