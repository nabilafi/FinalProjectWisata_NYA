package com.wisata_nya.mei.wisata_nyamalangraya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wisata_nya.mei.wisata_nyamalangraya.Adapter.FrontAboutusList;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.AboutUs;

import java.util.ArrayList;
import java.util.List;

public class FrontAboutus extends AppCompatActivity {

    DatabaseReference databaseAboutUs;

    ListView listViewAboutUs;

    List<AboutUs> frontAboutusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_aboutus);

        databaseAboutUs = FirebaseDatabase.getInstance().getReference("aboutUs");

        listViewAboutUs = (ListView) findViewById(R.id.listFrontViewAboutus);

        frontAboutusList = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseAboutUs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                frontAboutusList.clear();

                for(DataSnapshot aboutusSnapshot : dataSnapshot.getChildren())
                {
                    AboutUs aboutUs = aboutusSnapshot.getValue(AboutUs.class);

                    frontAboutusList.add(aboutUs);
                }

                FrontAboutusList adapter = new FrontAboutusList(FrontAboutus.this, frontAboutusList);
                listViewAboutUs.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
