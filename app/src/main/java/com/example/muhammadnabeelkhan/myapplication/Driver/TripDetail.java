package com.example.muhammadnabeelkhan.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muhammadnabeelkhan.myapplication.Driver.MapModule.MapActivity.MapActivity;
import com.example.muhammadnabeelkhan.myapplication.Model.Trips;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TripDetail extends AppCompatActivity {

    Button sMap;
    Trips val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

        val = new Trips();

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

        sMap = findViewById(R.id.btt);

        sMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TripDetail.this, MapActivity.class);
                startActivity(intent1);
            }
        });

        FirebaseDatabase.getInstance().getReference().child("Trips")
                .child(getname).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                if(dataSnapshot.exists())
                {
                    val = dataSnapshot.getValue(Trips.class);
                    if(val != null)
                    {
                        s.setText(val.getSource());
                        d.setText(val.getDestination());
                        dt.setText(val.getDepTime());
                        dd.setText(val.getDepDate());
                        at.setText(val.getArrTime());
                        ad.setText(val.getDepDate());
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

//    public void Maps (View view){
//        Intent intent = new Intent(TripDetail.this, StartTrip.class);
//        Bundle extras = new Bundle();
//        extras.putString("Source",sourcee);
//        extras.putString("Destination",des);
//        intent.putExtras(extras);
//        startActivity(intent);
//    }
}
