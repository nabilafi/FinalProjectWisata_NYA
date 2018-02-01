package com.wisata_nya.mei.wisata_nyamalangraya;

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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wisata_nya.mei.wisata_nyamalangraya.Adapter.AboutUsList;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.AboutUs;

import java.util.ArrayList;
import java.util.List;

public class CreateAboutUs extends AppCompatActivity {

    EditText txtDesc, txtVers;
    Button btnAddAboutUs;

    DatabaseReference databaseAboutUs;

    ListView listViewAboutUs;

    List<AboutUs> aboutUsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_about_us);

        databaseAboutUs = FirebaseDatabase.getInstance().getReference("aboutUs");

        txtVers = findViewById(R.id.etversAboutUs);
        txtDesc = findViewById(R.id.etdescAboutUs);
        btnAddAboutUs = findViewById(R.id.btnAddAboutUs);

        listViewAboutUs = (ListView) findViewById(R.id.listViewAboutUs);

        aboutUsList = new ArrayList<>();

        btnAddAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAboutUs();
            }
        });

        listViewAboutUs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AboutUs aboutUs = aboutUsList.get(position);

                showUpdateDialog(aboutUs.getAboutUsId(), aboutUs.getVersion());
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseAboutUs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                aboutUsList.clear();

                for(DataSnapshot aboutUsSnapshot : dataSnapshot.getChildren())
                {
                    AboutUs aboutUs = aboutUsSnapshot.getValue(AboutUs.class);

                    aboutUsList.add(aboutUs);
                }

                AboutUsList adapter = new AboutUsList(CreateAboutUs.this, aboutUsList);
                listViewAboutUs.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showUpdateDialog(final String aboutUsId, final String aboutUsVers)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_aboutus, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextVers = (EditText) dialogView.findViewById(R.id.editVers);
        final EditText editTextDesc = (EditText) dialogView.findViewById(R.id.editDesc);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.btnConfirmEditAboutUs);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.btnDeleteAboutUs);
        dialogBuilder.setTitle("Updating About Us "+aboutUsVers);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vers = editTextVers.getText().toString().trim();
                String desc = editTextDesc.getText().toString().trim();

                if(TextUtils.isEmpty(vers))
                {
                    editTextVers.setError("Version of this App Required !");
                    return;
                }

                updateAboutUs(aboutUsId, vers, desc);
                alertDialog.dismiss();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAboutUs(aboutUsId);
                alertDialog.dismiss();
            }
        });
    }

    private void deleteAboutUs(String aboutUsId) {
        DatabaseReference drAboutUs = FirebaseDatabase.getInstance().getReference("aboutUs").child(aboutUsId);
        drAboutUs.removeValue();

        Toast.makeText(this, "About Us is deleted", Toast.LENGTH_LONG).show();
    }

    private boolean updateAboutUs(String id, String vers, String desc)
    {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("aboutUs").child(id);
        AboutUs aboutUs = new AboutUs(id, vers, desc);
        databaseReference.setValue(aboutUs);

        Toast.makeText(this, "About Us Updated Successfully", Toast.LENGTH_LONG).show();
        return true;
    }

    private  void addAboutUs()
    {
        String vers = txtVers.getText().toString().trim();
        String desc = txtDesc.getText().toString().trim();

        if(!TextUtils.isEmpty(vers))
        {
            String id = databaseAboutUs.push().getKey();

            AboutUs aboutUs = new AboutUs(id,vers,desc);

            databaseAboutUs.child(id).setValue(aboutUs);

            Toast.makeText(this, "About Us added", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Silakan masukkan versi dari aplikasi Wisata_NYA", Toast.LENGTH_SHORT).show();
        }
    }
}
