package com.wisata_nya.mei.wisata_nyamalangraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wisata_nya.mei.wisata_nyamalangraya.Maps.MapsActivity;
//import com.wisata_nya.mei.wisata_nyamalangraya.Model.ShowDataItems;

public class DetailFrontWisata extends AppCompatActivity {

    String nama, alamat, jamOps, hargaTiket, contactPerson,koorX, koorY, id, deskripsi, kota, image_url;
    TextView txnama, txalamat, txjamOps, txhargaTiket, txcontactPerson, txkota, txdeskripsi;

    //+image
    ImageView imgDFWisata;
    private Button btnMapsWisata;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
//    private FirebaseRecyclerAdapter<ShowDataItems, ShowData.ShowDataViewHolder> mFirebaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_front_wisata);

        Intent i = getIntent();

        //+img
        firebaseDatabase = FirebaseDatabase.getInstance();
        // myRef = firebaseDatabase.getReference("User_Details");
        myRef = FirebaseDatabase.getInstance().getReference("User_Details");

        //Maps
        koorX = i.getStringExtra("koorX");
        koorY = i.getStringExtra("koorY");
        //Intent Button Wisata
        btnMapsWisata = findViewById(R.id.btnMapsWisata);
        btnMapsWisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(getApplicationContext(), MapsActivity.class);
                detail.putExtra("koorX", koorX);
                detail.putExtra("koorY", koorY);
                startActivity(detail);
            }
        });

        id = i.getStringExtra("id");
        nama = i.getStringExtra("nama");

        alamat = i.getStringExtra("alamat");
        jamOps = i.getStringExtra("jamOps");
        hargaTiket = i.getStringExtra("hargaTiket");
        contactPerson = i.getStringExtra("contactPerson");

        deskripsi = i.getStringExtra("deskripsi");
        kota = i.getStringExtra("kota");
        image_url = i.getStringExtra("image_url");

        txnama = findViewById(R.id.tViewNameDF);

        txalamat = findViewById(R.id.tViewAlamatDF);
        txjamOps = findViewById(R.id.tViewJamOpsDF);
        txhargaTiket = findViewById(R.id.tViewHargaTiketDF);
        txcontactPerson = findViewById(R.id.tViewContactPersonDF);

        txkota = findViewById(R.id.tViewDeskripsiDF);
        txdeskripsi = findViewById(R.id.tViewKotaDF);
        imgDFWisata = findViewById(R.id.imgDFWisata);

        txnama.setText(nama);

        txalamat.setText(alamat);
        txjamOps.setText(jamOps);
        txhargaTiket.setText(hargaTiket);
        txcontactPerson.setText(contactPerson);

        txdeskripsi.setText(deskripsi);
        txkota.setText(kota);

        //+img
        Glide.with(DetailFrontWisata.this).load(image_url).placeholder(R.drawable.loading).into(imgDFWisata);
    }

    //+img
    private void Image_URL(String title) {
        ;
    }
}