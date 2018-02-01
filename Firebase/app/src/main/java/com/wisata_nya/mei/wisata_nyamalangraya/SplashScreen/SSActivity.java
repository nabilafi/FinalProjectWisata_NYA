package com.wisata_nya.mei.wisata_nyamalangraya.SplashScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.wisata_nya.mei.wisata_nyamalangraya.PageUtama;
import com.wisata_nya.mei.wisata_nyamalangraya.R;

public class SSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_ss);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), PageUtama.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik

    }
}
