package com.example.muhammadnabeelkhan.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class DriverProfile extends AppCompatActivity {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("Drivers");
    String getname;
    String name;
    String CNIC;
    String City;
    String Gender;
    String Password;
    String Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_profile);

        Intent intent = getIntent();
        getname = intent.getStringExtra("DriverID");

        final TextView namee = (TextView) findViewById(R.id.textView8);
        final TextView CNICC = (TextView) findViewById(R.id.textView18);
        final TextView Cityy = (TextView) findViewById(R.id.textView19);
        final TextView Genderr = (TextView) findViewById(R.id.textView20);
        final TextView Passwordd = (TextView) findViewById(R.id.textView21);
        final TextView Phonee = (TextView) findViewById(R.id.textView16);

        TextView tv = (TextView) findViewById(R.id.textView17);
        tv.setText(getname);

        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    final Drivers val = snapshot.getValue(Drivers.class);
                    if (getname.equals(val.Id)) {
                        name = val.Name.toString();
                        CNIC = val.CNIC.toString();
                        City = val.city.toString();
                        Gender = val.gender.toString();
                        Password = val.password.toString();
                        Phone = val.phone.toString();

                        namee.setText(name);
                        CNICC.setText(CNIC);
                        Cityy.setText(City);
                        Genderr.setText(Gender);
                        Passwordd.setText(Password);
                        Phonee.setText(Phone);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "The read failed: " + databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
