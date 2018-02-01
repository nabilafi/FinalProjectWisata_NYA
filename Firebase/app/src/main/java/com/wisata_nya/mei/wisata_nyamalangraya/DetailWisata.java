package com.wisata_nya.mei.wisata_nyamalangraya;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wisata_nya.mei.wisata_nyamalangraya.Maps.MapsActivity;
//import com.wisata_nya.mei.wisata_nyamalangraya.Model.ShowDataItems;

public class DetailWisata extends AppCompatActivity {
    String nama,alamat,jamOps,hargaTiket,contactPerson, koorX, koorY, id, deskripsi, kota, image_url;
    TextView txnama, txalamat, txjamOps, txhargaTiket, txcontactPerson,txkoorX, txkoorY, txkota, txdeskripsi;
    ImageView imgDWisata;
    private Button btnMapsWisata;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
//    private FirebaseRecyclerAdapter<ShowDataItems, ShowData.ShowDataViewHolder> mFirebaseAdapter;
//
//    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        Intent i = getIntent();

        firebaseDatabase = FirebaseDatabase.getInstance();
        // myRef = firebaseDatabase.getReference("User_Details");
        myRef = FirebaseDatabase.getInstance().getReference("User_Details");
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
        hargaTiket =i.getStringExtra("hargaTiket");
        contactPerson = i.getStringExtra("contactPerson");



        deskripsi = i.getStringExtra("deskripsi");
        kota = i.getStringExtra("kota");
        image_url = i.getStringExtra("image_url");


        txnama = findViewById(R.id.tViewNameD);

        txalamat = findViewById(R.id.tViewAlamatD);
        txjamOps = findViewById(R.id.tViewJamOpsD);
        txhargaTiket = findViewById(R.id.tViewHargaTiketD);
        txcontactPerson = findViewById(R.id.tViewContactPersonD);

        txkoorX = findViewById(R.id.tViewKoorXD);
        txkoorY = findViewById(R.id.tViewKoorYD);

        txkota = findViewById(R.id.tViewDeskripsiD);
        txdeskripsi = findViewById(R.id.tViewKotaD);
        imgDWisata = findViewById(R.id.imgDWisata);

        txnama.setText(nama);

        txalamat.setText(alamat);
        txjamOps.setText(jamOps);
        txhargaTiket.setText(hargaTiket);
        txcontactPerson.setText(contactPerson);

        txkoorX.setText(koorX);
        txkoorY.setText(koorY);

        txdeskripsi.setText(deskripsi);
        txkota.setText(kota);

        Glide.with(DetailWisata.this).load(image_url).placeholder(R.drawable.loading).into(imgDWisata);



    }
    private void Image_URL(String title) {
        ;
    }
}
