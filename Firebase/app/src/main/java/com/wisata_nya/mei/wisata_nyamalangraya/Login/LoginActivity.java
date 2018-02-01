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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSignIn;
    private EditText etEmail, etPassword;
    private TextView tvSignUp;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null)
        {
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvSignUp = findViewById(R.id.tvSignUp);

        progressDialog = new ProgressDialog(this);

        btnSignIn.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);

    }

    private void userLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim(); //video typo

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

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful())
                        {
                            //start profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if (view == btnSignIn)
        {
            userLogin();
        }

        if(view == tvSignUp)
        {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
