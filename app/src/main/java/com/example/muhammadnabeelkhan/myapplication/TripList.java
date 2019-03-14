package com.example.muhammadnabeelkhan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TripList extends AppCompatActivity {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("tripAssign");
    String getname;
    String TID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);

        Intent intent = getIntent();
        getname = intent.getStringExtra("DriverID");

        final ArrayList<String> list1 = new ArrayList<>();
        final ListView view1 = (ListView) findViewById(R.id.list_item);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list1);
        view1.setAdapter(arrayAdapter);

        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    final tripAssign val = snapshot.getValue(tripAssign.class);
                    if (getname.equals(val.driverid)) {
                        TID = val.tripID.toString();

                        view1.setAdapter(arrayAdapter);
                        list1.add(TID);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "The read failed: " + databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        view1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String)adapterView.getItemAtPosition(i);
                Intent intent12 = new Intent(TripList.this, TripDetail.class);
                intent12.putExtra("key",value);
                startActivity(intent12);
            }
        });

    }
}
