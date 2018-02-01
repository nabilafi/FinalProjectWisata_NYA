package com.wisata_nya.mei.wisata_nyamalangraya.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.wisata_nya.mei.wisata_nyamalangraya.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRegister;
    private EditText etTextEmail, etTextPassword;
    private TextView tvSignIn;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null)
        {
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        btnRegister = findViewById(R.id.btnRegister);

        etTextEmail = findViewById(R.id.etEmail);
        etTextPassword=findViewById(R.id.etPassword);

        tvSignIn = findViewById(R.id.tvSignIn);

        btnRegister.setOnClickListener(this);
        tvSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == btnRegister)
        {
            registerUser();
        }

        if(view == tvSignIn)
        {
            //open login activity in here
            startActivity(new Intent(this, LoginActivity.class));
        }

    }


    private void registerUser() {

        String email = etTextEmail.getText().toString().trim();
        String password = etTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email))
        {
            //email kosong
            Toast.makeText(this, "Email harap diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password))
        {
            //password kosong
            Toast.makeText(this, "Password harap diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        //jika validasi terpenuhi, tampilkan progressbar
        progressDialog.setMessage("Register User");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            //activity start
//                            Toast.makeText(MainActivity.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
//                            if(firebaseAuth.getCurrentUser()!=null)
//                            {
                                //profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
//                            }


                        }
                        else {
                            //activity start
                            Toast.makeText(MainActivity.this, "Registrasi Gagal, Coba Lagi", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }
}
