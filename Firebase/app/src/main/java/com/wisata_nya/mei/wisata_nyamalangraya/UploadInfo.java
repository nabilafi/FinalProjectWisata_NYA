package com.wisata_nya.mei.wisata_nyamalangraya;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

/**
 * Created by Nabila on 1/20/2018.
 */

public class UploadInfo extends AppCompatActivity {

    Button selectImage, uploadButton;
    ImageView userImage;
    TextView name;

    public static final int READ_EXTERNAL_STORAGE = 0;
    private static final int GALLERY_INTENT = 2;
    private ProgressDialog mProgressDialog;
    private Firebase mRoofRef;
    private Uri mImageUri = null;
    private DatabaseReference mDatabaseReference;
    private StorageReference mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_photo);

        Intent i = getIntent();
        String id = i.getStringExtra("id");
        Firebase.setAndroidContext(this);

        selectImage = findViewById(R.id.selectImage);
        uploadButton = findViewById(R.id.btnUploadPhotoConfirm);
        userImage = findViewById(R.id.user_image);
        name = findViewById(R.id.etName);

        mProgressDialog = new ProgressDialog(UploadInfo.this);

        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Call for Permission", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
                    }
                } else {
                    callgalary();
                }
            }
        });

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mRoofRef = new Firebase("https://wisatanya-89184.firebaseio.com/").child("oWisata").child(id);
        mStorage = FirebaseStorage.getInstance().getReferenceFromUrl("gs://wisatanya-89184.appspot.com");

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mName = name.getText().toString().trim();

                if (mName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill all Field, please", Toast.LENGTH_SHORT).show();
                    return;
                }

                Firebase childRef_name = mRoofRef.child("Image_Title");
                childRef_name.setValue(mName);

                Toast.makeText(getApplicationContext(), "Updated Info", Toast.LENGTH_SHORT).show();

            }
        });

    }
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            switch (requestCode) {
                case READ_EXTERNAL_STORAGE:
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                        callgalary();
                    return;
            }
            Toast.makeText(getApplicationContext(), "...", Toast.LENGTH_SHORT).show();
        }



        //If Access Granted gallery Will open
        private void callgalary() {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, GALLERY_INTENT);
        }


        //After Selecting image from gallery image will directly uploaded to Firebase Database
        //and Image will Show in Image View
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {

                mImageUri = data.getData();
                userImage.setImageURI(mImageUri);
                StorageReference filePath = mStorage.child("User_Images").child(mImageUri.getLastPathSegment());

                mProgressDialog.setMessage("Uploading Image....");
                mProgressDialog.show();

                filePath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Uri downloadUri = taskSnapshot.getDownloadUrl();  //Ignore This error

                        mRoofRef.child("Image_URL").setValue(downloadUri.toString());

                        Glide.with(getApplicationContext())
                                .load(downloadUri)
                                .crossFade()
                                .placeholder(R.drawable.loading)
                                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                                .into(userImage);
                        Toast.makeText(getApplicationContext(), "Updated.", Toast.LENGTH_SHORT).show();
                        mProgressDialog.dismiss();
                    }
                });
            }
        }
    }