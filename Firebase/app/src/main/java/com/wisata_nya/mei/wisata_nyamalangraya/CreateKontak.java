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
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wisata_nya.mei.wisata_nyamalangraya.Adapter.KontakList;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.Kontak;

import java.util.ArrayList;
import java.util.List;

public class CreateKontak extends AppCompatActivity {

    EditText etKet;
    Button btnAddKontak;
    Spinner spinnerSosmed;

    DatabaseReference databaseKontak;

    ListView listViewKontak;

    List<Kontak> kontakList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_kontak);

        databaseKontak = FirebaseDatabase.getInstance().getReference("kontak");

        etKet = findViewById(R.id.etKet);
        btnAddKontak = findViewById(R.id.btnAddKontak);
        spinnerSosmed = findViewById(R.id.spinnerSosmed);

        listViewKontak = (ListView) findViewById(R.id.listViewKontak);

        kontakList = new ArrayList<>();

        btnAddKontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addKontak();
            }
        });

        listViewKontak.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Kontak kontak = kontakList.get(position);

                showUpdateDialog(kontak.getKontakId(), kontak.getKontakKet());
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseKontak.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                kontakList.clear();

                for(DataSnapshot kontakSnapshot : dataSnapshot.getChildren())
                {
                    Kontak kontak = kontakSnapshot.getValue(Kontak.class);

                    kontakList.add(kontak);
                }

                KontakList adapter = new KontakList(CreateKontak.this, kontakList);
                listViewKontak.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showUpdateDialog(final String kontakId, String kontakKeterangan)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_kontak, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextKet = (EditText) dialogView.findViewById(R.id.editKet);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.btnConfirmEditKontak);
        final Spinner spinnerEditKontak = (Spinner) dialogView.findViewById(R.id.spinnerEditSosmed);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.btnDeleteKontak);
        dialogBuilder.setTitle("Updating Kontak "+kontakKeterangan);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ket = editTextKet.getText().toString().trim();
                String sosmed = spinnerEditKontak.getSelectedItem().toString();

                if(TextUtils.isEmpty(ket))
                {
                    editTextKet.setError("Keterangan Required !");
                    return;
                }

                updateKontak(kontakId, ket, sosmed);
                alertDialog.dismiss();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteKontak(kontakId);
                alertDialog.dismiss();
            }
        });
    }

    private void deleteKontak(String kontakId) {
        DatabaseReference drKontak = FirebaseDatabase.getInstance().getReference("kontak").child(kontakId);
        drKontak.removeValue();

        Toast.makeText(this, "Kontak is deleted", Toast.LENGTH_LONG).show();
    }

    private boolean updateKontak(String id, String ket, String sosmed)
    {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("kontak").child(id);
        Kontak kontak = new Kontak(id, ket, sosmed);
        databaseReference.setValue(kontak);

        Toast.makeText(this, "Kontak Updated Successfully", Toast.LENGTH_LONG).show();
        return true;
    }

    private  void addKontak()
    {
        String ket = etKet.getText().toString().trim();
        String sosmed = spinnerSosmed.getSelectedItem().toString();

        if(!TextUtils.isEmpty(ket))
        {
            String id = databaseKontak.push().getKey();

            Kontak kontak = new Kontak(id,ket,sosmed);

            databaseKontak.child(id).setValue(kontak);

            Toast.makeText(this, "Kontak added", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Silakan masukkan keterangan kontak", Toast.LENGTH_SHORT).show();
        }
    }
}
