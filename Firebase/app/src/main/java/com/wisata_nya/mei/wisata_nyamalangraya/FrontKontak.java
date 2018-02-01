package com.wisata_nya.mei.wisata_nyamalangraya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wisata_nya.mei.wisata_nyamalangraya.Adapter.FrontKontakList;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.Kontak;

import java.util.ArrayList;
import java.util.List;

public class FrontKontak extends AppCompatActivity {

    DatabaseReference databaseKontak;

    ListView listViewKontak;

    List<Kontak> frontKontakList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_kontak);

        databaseKontak = FirebaseDatabase.getInstance().getReference("kontak");

        listViewKontak = (ListView) findViewById(R.id.listFrontViewKontak);

        frontKontakList = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseKontak.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                frontKontakList.clear();

                for(DataSnapshot kontakSnapshot : dataSnapshot.getChildren())
                {
                    Kontak kontak = kontakSnapshot.getValue(Kontak.class);

                    frontKontakList.add(kontak);
                }

                FrontKontakList adapter = new FrontKontakList(FrontKontak.this, frontKontakList);
                listViewKontak.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
