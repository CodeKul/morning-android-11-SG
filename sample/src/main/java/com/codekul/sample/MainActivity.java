package com.codekul.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCar(View view) {
        Toast.makeText(this, "Car", Toast.LENGTH_SHORT).show();
        ImageView img = findViewById(R.id.imgVeh);
        img.setImageResource(R.drawable.ic_directions_bike_black_24dp);
    }

    public void onPlane(View view) {
        Toast.makeText(this, "Plane", Toast.LENGTH_SHORT).show();
        ImageView img = findViewById(R.id.imgVeh);
        img.setImageResource(R.drawable.ic_chopper);
    }
}
