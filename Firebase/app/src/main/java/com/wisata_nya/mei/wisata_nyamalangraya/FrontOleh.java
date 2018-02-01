package com.wisata_nya.mei.wisata_nyamalangraya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wisata_nya.mei.wisata_nyamalangraya.Adapter.FrontOlehList;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.Oleh;

import java.util.ArrayList;
import java.util.List;

public class FrontOleh extends AppCompatActivity {

        DatabaseReference databaseOleh;

        ListView listViewOleh;

        List<Oleh> frontOlehList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_front_oleh);

            databaseOleh = FirebaseDatabase.getInstance().getReference("oleh");

            listViewOleh = (ListView) findViewById(R.id.listFrontViewOleh);

            frontOlehList = new ArrayList<>();
        }



        @Override
        protected void onStart() {
            super.onStart();

            databaseOleh.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    frontOlehList.clear();

                    for(DataSnapshot olehsSnapshot : dataSnapshot.getChildren())
                    {
                        Oleh oleh = olehsSnapshot.getValue(Oleh.class);

                        frontOlehList.add(oleh);
                    }

                    FrontOlehList adapter = new FrontOlehList(FrontOleh.this, frontOlehList);
                    listViewOleh.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

    }
