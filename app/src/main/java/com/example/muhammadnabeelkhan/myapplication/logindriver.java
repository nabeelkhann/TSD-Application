package com.example.muhammadnabeelkhan.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.xmlpull.v1.sax2.Driver;

import java.net.HttpCookie;

public class logindriver extends AppCompatActivity {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("Drivers");
    Button log;
    EditText id;
    EditText pass;
    int i=0;
    String gettt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logindriver);

        id = (EditText)findViewById(R.id.editText8);
        pass = (EditText)findViewById(R.id.editText9);

    }
    public void Home(View view) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Sign in");
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        
        final String idd = id.getText().toString();
        final String passs = pass.getText().toString();


        if(idd.equals("") || passs.equals("")){
            AlertDialog alert = new AlertDialog.Builder(logindriver.this).create();
            alert.setTitle("Alert");
            alert.setMessage("ID or Password are empty");
            alert.show();
        }
        else{
            mRootRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    i=0;
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        final Drivers val = snapshot.getValue(Drivers.class);
                        if(idd.equals(val.Id) && passs.equals(val.password)){
                            i=1;
                            gettt=val.Id.toString();
                        }
                    }
                    if(i==1){
                        progressDialog.dismiss();
                        Intent intent = new Intent(logindriver.this, DrawerActivity.class);
                        intent.putExtra("DriverID",gettt);
                        startActivity(intent);
                    }
                    else{
                        AlertDialog alert = new AlertDialog.Builder(logindriver.this).create();
                        alert.setTitle("Alert");
                        alert.setMessage("Not Found! Enter Correct id or password.");
                        alert.show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), "The read failed: " + databaseError.getCode(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
