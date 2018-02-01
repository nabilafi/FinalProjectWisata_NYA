package com.wisata_nya.mei.wisata_nyamalangraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wisata_nya.mei.wisata_nyamalangraya.Login.LoginActivity;
import com.wisata_nya.mei.wisata_nyamalangraya.Maps.MapsActivity;

public class PageUtama extends AppCompatActivity implements View.OnClickListener{

    String koorX,koorY;
    private Button btnLogin, btnWisata, btnAboutUs, btnKontak, btnOleh, btnMaps;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_utama);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener((View.OnClickListener) this);

        btnWisata = findViewById(R.id.btnWisata);
        btnWisata.setOnClickListener((View.OnClickListener) this);

        btnAboutUs = findViewById(R.id.btnAboutUs);
        btnAboutUs.setOnClickListener((View.OnClickListener) this);

        btnKontak = findViewById(R.id.btnKontak);
        btnKontak.setOnClickListener((View.OnClickListener) this);

        btnOleh = findViewById(R.id.btnOleh);
        btnOleh.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin)
        {
            startActivity(new Intent(this, LoginActivity.class));
        }

        if(view == btnWisata)
        {
            startActivity(new Intent(this, FrontOWisata.class));
        }

        if(view == btnAboutUs)
        {
            startActivity(new Intent(this, FrontAboutus.class));
        }

        if(view == btnKontak)
        {
            startActivity(new Intent(this, FrontKontak.class));
        }

        if(view == btnOleh)
        {
            startActivity(new Intent(this, FrontOleh.class));
        }
    }
}
