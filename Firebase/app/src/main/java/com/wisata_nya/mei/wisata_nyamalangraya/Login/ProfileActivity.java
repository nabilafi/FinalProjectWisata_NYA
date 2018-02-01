package com.wisata_nya.mei.wisata_nyamalangraya.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.wisata_nya.mei.wisata_nyamalangraya.CreateAboutUs;
import com.wisata_nya.mei.wisata_nyamalangraya.CreateKontak;
import com.wisata_nya.mei.wisata_nyamalangraya.CreateOWisata;
import com.wisata_nya.mei.wisata_nyamalangraya.CreateOleh;
import com.wisata_nya.mei.wisata_nyamalangraya.R;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView tvUserEmail;
    private Button btnLogout, btnWisata,btnKontak, btnAboutUs, btnOleh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        tvUserEmail = findViewById(R.id.tvUserEmail);

        tvUserEmail.setText("Selamat Datang " +user.getEmail());

        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(this);

        btnWisata = findViewById(R.id.btnWisata);
        btnWisata.setOnClickListener(this);

        btnKontak = findViewById(R.id.btnKontak);
        btnKontak.setOnClickListener(this);

        btnAboutUs = findViewById(R.id.btnAboutUs);
        btnAboutUs.setOnClickListener(this);

        btnOleh = findViewById(R.id.btnOleh);
        btnOleh.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == btnLogout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        if(view == btnWisata)
        {
            startActivity(new Intent(this, CreateOWisata.class));
        }

        if(view == btnKontak)
        {
            startActivity(new Intent(this, CreateKontak.class));
        }

        if(view == btnAboutUs)
        {
            startActivity(new Intent(this, CreateAboutUs.class));
        }

        if(view == btnOleh)
        {
            startActivity(new Intent(this, CreateOleh.class));
        }

    }
}
