package com.wisata_nya.mei.wisata_nyamalangraya;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wisata_nya.mei.wisata_nyamalangraya.Adapter.FrontOWisataList;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.OWisata;

import java.util.ArrayList;
import java.util.List;

public class FrontOWisata extends AppCompatActivity {

    EditText etKoorX, etKoorY;

    DatabaseReference databaseOWisata;

    ListView listViewOWisata;

    List<OWisata> frontOWisataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_owisata);

        databaseOWisata = FirebaseDatabase.getInstance().getReference("oWisata");

        listViewOWisata = (ListView) findViewById(R.id.listFrontViewOWisata);

        frontOWisataList = new ArrayList<>();

        listViewOWisata.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                OWisata owisata=frontOWisataList.get(position);

                showUpdateDialog(owisata.getOwisataId(), owisata.getOwisataName(), owisata.getOwisataAlamat(), owisata.getOwisataJamOps(), owisata.getOwisataHargaTiket(), owisata.getOwisataContactPerson(), owisata.getOwisataKoorX(), owisata.getOwisataKoorY(), owisata.getOwisataDeskripsi(), owisata.getOwisataKota(), owisata.getImage_URL());
                return false;
            }
        });
    }

    private void showUpdateDialog(final String oWisataid, final String oWisataName, final String oWisataAlamat, final String oWisataJamOps, final String oWisataHargaTiket, final String owisataContactPerson, final String oWisataKoorX, final String oWisataKoorY, final String owisataDeskripsi, final String oWisataKota, final String owisataUrl)
    {

        Intent detail = new Intent(getApplicationContext(), DetailFrontWisata.class);
        detail.putExtra("id", oWisataid);
        detail.putExtra("nama", oWisataName);

        detail.putExtra("alamat", oWisataAlamat);
        detail.putExtra("jamOps", oWisataJamOps);
        detail.putExtra("hargaTiket", oWisataHargaTiket);
        detail.putExtra("contactPerson", owisataContactPerson);

        detail.putExtra("koorX", oWisataKoorX);
        detail.putExtra("koorY", oWisataKoorY);

        detail.putExtra("deskripsi", owisataDeskripsi);
        detail.putExtra("kota", oWisataKota);
        detail.putExtra("image_url", owisataUrl);
        startActivity(detail);
    }


    @Override
    protected void onStart() {
        super.onStart();

        databaseOWisata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                frontOWisataList.clear();

                for(DataSnapshot oWisataSnapshot : dataSnapshot.getChildren())
                {
                    OWisata oWisata = oWisataSnapshot.getValue(OWisata.class);

                    frontOWisataList.add(oWisata);
                }

                FrontOWisataList adapter = new FrontOWisataList(FrontOWisata.this, frontOWisataList);
                listViewOWisata.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
