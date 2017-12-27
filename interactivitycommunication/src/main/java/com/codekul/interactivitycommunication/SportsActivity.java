package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

       Intent intent =  getIntent();
       Bundle bundle = intent.getExtras();
       if(bundle != null) {
           ((TextView)findViewById(R.id.txtCmp))
                   .setText(bundle.getString("yoNm"));
       }
    }

    public void onMain(View view) {

    }
}
