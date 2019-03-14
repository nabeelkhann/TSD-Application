package com.example.muhammadnabeelkhan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.sql.Driver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Driver(View view) {
        Intent intent = new Intent(MainActivity.this, logindriver.class);
        startActivity(intent);
    }
    public void steward(View view) {
        Intent intent = new Intent(MainActivity.this, loginsteward.class);
        startActivity(intent);
    }
    public void ticketchecker(View view) {
        Intent intent = new Intent(MainActivity.this, logintc.class);
        startActivity(intent);
    }
}
