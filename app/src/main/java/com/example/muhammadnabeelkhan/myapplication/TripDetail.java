package com.example.muhammadnabeelkhan.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TripDetail extends AppCompatActivity {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("Trips");
    String sourcee;
    String des;
    String depT;
    String depD;
    String ArrT;
    String ArrD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

        TextView name = (TextView) findViewById(R.id.tv1);
        Intent intent = getIntent();
        final String getname = intent.getStringExtra("key");
        name.setText(getname);

        final TextView s = (TextView) findViewById(R.id.tv2);
        final TextView d = (TextView) findViewById(R.id.tv3);
        final TextView dt = (TextView) findViewById(R.id.tv4);
        final TextView dd = (TextView) findViewById(R.id.tv5);
        final TextView at = (TextView) findViewById(R.id.tv6);
        final TextView ad = (TextView) findViewById(R.id.tv7);

        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    final Trips val = snapshot.getValue(Trips.class);
                    String foo = Integer.toString(val.tripID);
                    if (getname.equals(foo)) {

                        sourcee = val.source.toString();
                        des = val.destination.toString();
                        depT = val.depTime.toString();
                        depD = val.depDate.toString();
                        ArrT = val.arrTime.toString();
                        ArrD = val.arrDate.toString();

                        s.setText(sourcee);
                        d.setText(des);
                        dt.setText(depT);
                        dd.setText(depD);
                        at.setText(ArrT);
                        ad.setText(ArrD);
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
