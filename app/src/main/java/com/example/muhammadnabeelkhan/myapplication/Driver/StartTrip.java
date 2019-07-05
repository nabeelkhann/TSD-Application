package com.example.muhammadnabeelkhan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class StartTrip extends AppCompatActivity {

    String Source;
    String Destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_trip);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Source = extras.getString("Source");
        Destination = extras.getString("Destination");

    }
}
