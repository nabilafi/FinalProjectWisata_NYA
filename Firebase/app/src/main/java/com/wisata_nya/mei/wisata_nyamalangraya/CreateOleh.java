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

import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wisata_nya.mei.wisata_nyamalangraya.Adapter.OlehList;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.Oleh;

import java.util.ArrayList;
import java.util.List;

public class CreateOleh extends AppCompatActivity {

    EditText txtOlehNama, txtOlehHarga, txtOlehVarian, txtOlehKeterangan;
    Button btnAddOleh;

    DatabaseReference databaseOleh;

    ListView listViewOleh;

    List<Oleh> olehList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_oleh);

        databaseOleh = FirebaseDatabase.getInstance().getReference("oleh");

        txtOlehNama = findViewById(R.id.etNamaOleh);
        txtOlehHarga = findViewById(R.id.etHargaOleh);
        txtOlehVarian = findViewById(R.id.etVarianOleh);
        txtOlehKeterangan = findViewById(R.id.etKeteranganOleh);

        btnAddOleh = findViewById(R.id.btnAddOleh);

        listViewOleh = (ListView) findViewById(R.id.listViewOleh);

        olehList = new ArrayList<>();

        btnAddOleh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOleh();
            }
        });

        listViewOleh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Oleh oleh = olehList.get(position);

                showUpdateDialog(oleh.getOlehId(), oleh.getOlehNama());
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseOleh.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                olehList.clear();

                for(DataSnapshot olehSnapshot : dataSnapshot.getChildren())
                {
                    Oleh oleh = olehSnapshot.getValue(Oleh.class);

                    olehList.add(oleh);
                }

                OlehList adapter = new OlehList(CreateOleh.this, olehList);
                listViewOleh.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void showUpdateDialog(final String olehId, final String olehNama)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_oleh, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextOlehNama = (EditText) dialogView.findViewById(R.id.editOlehNama);
        final EditText editTextOlehHarga = (EditText) dialogView.findViewById(R.id.editOlehHarga);
        final EditText editTextOlehVarian = (EditText) dialogView.findViewById(R.id.editOlehVarian);
        final EditText editTextOlehKeterangan = (EditText) dialogView.findViewById(R.id.editOlehKeterangan);

        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.btnConfirmEditOleh);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.btnDeleteOleh);
        dialogBuilder.setTitle("Updating Oleh - Oleh "+olehNama);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String olehNama = editTextOlehNama.getText().toString().trim();
                String olehHarga = editTextOlehHarga.getText().toString().trim();
                String olehVarian = editTextOlehVarian.getText().toString().trim();
                String olehKeterangan = editTextOlehKeterangan.getText().toString().trim();

                if(TextUtils.isEmpty(olehNama))
                {
                    editTextOlehNama.setError("Isi Nama Oleh  - Oleh");
                    return;
                }

                updateOleh(olehId, olehNama, olehHarga, olehVarian, olehKeterangan);
                alertDialog.dismiss();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteOleh(olehId);
                alertDialog.dismiss();
            }
        });
    }

    private void deleteOleh(String aboutUsId) {
        DatabaseReference drOleh = FirebaseDatabase.getInstance().getReference("oleh").child(aboutUsId);
        drOleh.removeValue();

        Toast.makeText(this, "Oleh is deleted", Toast.LENGTH_LONG).show();
    }

    private boolean updateOleh(String id, String olehNama, String olehHarga, String olehVarian, String olehKeterangan)
    {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("oleh").child(id);
        Oleh oleh = new Oleh(id, olehNama, olehHarga, olehVarian, olehKeterangan);
        databaseReference.setValue(oleh);

        Toast.makeText(this, "Oleh Updated Successfully", Toast.LENGTH_LONG).show();
        return true;
    }

    private  void addOleh()
    {
        String olehNama = txtOlehNama.getText().toString().trim();
        String olehHarga = txtOlehHarga.getText().toString().trim();
        String olehVarian = txtOlehVarian.getText().toString().trim();
        String olehKeterangan = txtOlehKeterangan.getText().toString().trim();

        if(!TextUtils.isEmpty(olehNama))
        {
            String id = databaseOleh.push().getKey();

            Oleh oleh = new Oleh(id,olehNama,olehHarga, olehVarian, olehKeterangan);

            databaseOleh.child(id).setValue(oleh);

            Toast.makeText(this, "Oleh added", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Silakan masukkan nama oleh - oleh", Toast.LENGTH_SHORT).show();
        }
    }
}

