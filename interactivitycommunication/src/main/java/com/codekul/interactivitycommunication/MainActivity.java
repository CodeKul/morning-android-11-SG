package com.codekul.interactivitycommunication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSports(View view) {

        MainActivity main = this;
        Context con = main;

        Class<SportsActivity> cls = SportsActivity.class;

        Intent intent = new Intent(
                con,
                cls
        );

        EditText edNm = findViewById(R.id.edtNm);

        Bundle bundle = new Bundle();
        bundle.putString("yoNm", edNm.getText().toString());

        intent.putExtras(bundle);

        startActivity(intent);

        Car c = new Car();
        Car cB = new Bmw();
    }
}

class Car {

}

class Bmw  extends  Car{

}
