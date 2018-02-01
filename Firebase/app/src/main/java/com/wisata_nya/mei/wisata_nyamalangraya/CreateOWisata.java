package com.wisata_nya.mei.wisata_nyamalangraya;

import android.content.Intent;
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
import com.wisata_nya.mei.wisata_nyamalangraya.Adapter.OWisataList;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.OWisata;
import com.wisata_nya.mei.wisata_nyamalangraya.R;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

public class CreateOWisata extends AppCompatActivity {

    EditText etName, etAlamat, etJamOps, etHargaTiket, etContactPerson, etDeskripsi, etKoorX, etKoorY;
    Button btnAddWisata, btnUploadPhoto;
    Spinner spinnerKota;

    DatabaseReference databaseOWisata;

    ListView listViewOWisata;

    List<OWisata> oWisataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_owisata);

        databaseOWisata = FirebaseDatabase.getInstance().getReference("oWisata");

        etName = findViewById(R.id.etName);
        etAlamat = findViewById(R.id.etAlamat);
        etJamOps = findViewById(R.id.etJamOps);
        etHargaTiket =findViewById(R.id.etHargaTiket);
        etContactPerson = findViewById(R.id.etContactPerson);
        etDeskripsi = findViewById(R.id.etDeskripsi);
        etKoorX = findViewById(R.id.etKoorX);
        etKoorY = findViewById(R.id.etKoorY);

        btnAddWisata = findViewById(R.id.btnAddWisata);

        spinnerKota = findViewById(R.id.spinnerKota);

        listViewOWisata = (ListView) findViewById(R.id.listViewOWisata);

        oWisataList = new ArrayList<>();


        btnAddWisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOWisata();
            }
        });

        listViewOWisata.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                OWisata owisata= oWisataList.get(position);

                showUpdateDialog(owisata.getOwisataId(), owisata.getOwisataName(),

                        owisata.getOwisataAlamat(),owisata.getOwisataJamOps(),owisata.getOwisataHargaTiket(),owisata.getOwisataContactPerson()

                        , owisata.getOwisataDeskripsi(), owisata.getOwisataKoorX(),owisata.getOwisataKoorY(), owisata.getOwisataKota(), owisata.getImage_URL());
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseOWisata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                oWisataList.clear();

                for(DataSnapshot oWisataSnapshot : dataSnapshot.getChildren())
                {
                    OWisata oWisata = oWisataSnapshot.getValue(OWisata.class);
                    String aa = oWisata.getImage_URL();
                    String bb = oWisata.getOwisataName();
                    oWisataList.add(oWisata);
                }

                OWisataList adapter = new OWisataList(CreateOWisata.this, oWisataList);
                listViewOWisata.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showUpdateDialog(final String oWisataid, final String oWisataName,

                                  final String oWisataAlamat, final String oWisataJamOps, final String oWisataHargaTiket, final String oWisataContactPerson,

                                  final String owisataDeskripsi, final String oWisataKoorX, final String oWisataKoorY, final String oWisataKota,
                                  final String owisataUrl)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_owisata, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editName);

        final EditText editTextAlamat = (EditText) dialogView.findViewById(R.id.editAlamat);
        final EditText editTextJamOps = (EditText) dialogView.findViewById(R.id.editJamOps);
        final EditText editTextHargaTiket = (EditText) dialogView.findViewById(R.id.editHargaTiket);
        final EditText editTextContactPerson = (EditText) dialogView.findViewById(R.id.editContactPerson);

        final EditText editTextKoorX = (EditText) dialogView.findViewById(R.id.etKoorX);
        final EditText editTextKoorY = (EditText) dialogView.findViewById(R.id.etKoorY);


        final EditText editTextDeskripsi = (EditText) dialogView.findViewById(R.id.editDeskripsi);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.btnConfirmEditOWisata);
        final Button btnUploadPhoto = dialogView.findViewById(R.id.btnUploadPhoto);
        final Spinner spinnerEditKota = (Spinner) dialogView.findViewById(R.id.spinnerEditKota);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.btnDeleteOWisata);
        final Button buttonDetail = dialogView.findViewById(R.id.btnDetailOWisata);

        dialogBuilder.setTitle("Updating Wisata "+oWisataName);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();

                String alamat = editTextAlamat.getText().toString().trim();
                String jamOps = editTextJamOps.getText().toString().trim();
                String hargaTiket = editTextHargaTiket.getText().toString().trim();
                String contactPerson = editTextContactPerson.getText().toString().trim();

                String koorX = editTextKoorX.getText().toString().trim();
                String koorY = editTextKoorY.getText().toString().trim();

                String deskripsi = editTextDeskripsi.getText().toString().trim();
                String kota = spinnerEditKota.getSelectedItem().toString();

                if(TextUtils.isEmpty(name))
                {
                    editTextName.setError("Name Required !");
                    return;
                }

                updateOWisata(oWisataid, name,alamat,jamOps,hargaTiket,contactPerson,deskripsi,koorX, koorY, kota);
                alertDialog.dismiss();
            }
        });

        buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(getApplicationContext(), DetailWisata.class);
                detail.putExtra("id", oWisataid);
                detail.putExtra("nama", oWisataName);

                detail.putExtra("alamat", oWisataAlamat);
                detail.putExtra("jamOps", oWisataJamOps);
                detail.putExtra("hargaTiket", oWisataHargaTiket);
                detail.putExtra("contactPerson", oWisataContactPerson);

                detail.putExtra("koorX", oWisataKoorX);
                detail.putExtra("koorY", oWisataKoorY);

                detail.putExtra("deskripsi", owisataDeskripsi);
                detail.putExtra("kota", oWisataKota);
                detail.putExtra("image_url", owisataUrl);
                startActivity(detail);

            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteOWisata(oWisataid);
                alertDialog.dismiss();
            }
        });

        btnUploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UploadInfo.class);
                i.putExtra("id", oWisataid);
                startActivity(i);
            }
        });
    }



    private void deleteOWisata(String oWisataid) {
        DatabaseReference drOWisata = FirebaseDatabase.getInstance().getReference("oWisata").child(oWisataid);
        drOWisata.removeValue();

        Toast.makeText(this, "Wisata is deleted", Toast.LENGTH_LONG).show();
    }

    private boolean updateOWisata(String id, String name,String alamat, String jamOps, String hargaTiket, String contactPerson ,String deskripsi, String koorX, String koorY, String kota)
    {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("oWisata").child(id);
        OWisata oWisata = new OWisata(id, name,alamat,jamOps,hargaTiket,contactPerson, deskripsi, koorX, koorY, kota);
        databaseReference.setValue(oWisata);

        Toast.makeText(this, "Wisata Updated Successfully", Toast.LENGTH_LONG).show();
        return true;
    }

    private  void addOWisata()
    {
        String name = etName.getText().toString().trim();

        String alamat = etAlamat.getText().toString().trim();
        String jamOps = etJamOps.getText().toString().trim();
        String hargaTiket = etHargaTiket.getText().toString().trim();
        String contactPerson = etContactPerson.getText().toString().trim();

        String koorX = etKoorX.getText().toString().trim();
        String koorY = etKoorY.getText().toString().trim();

        String deskripsi = etDeskripsi.getText().toString().trim();
        String kota = spinnerKota.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name))
        {
            String id = databaseOWisata.push().getKey();

            OWisata oWisata = new OWisata(id,name,alamat,jamOps,hargaTiket,contactPerson,deskripsi,koorX, koorY,kota);

            databaseOWisata.child(id).setValue(oWisata);

            Toast.makeText(this, "Wisata added", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Silakan masukkan nama objek wisata", Toast.LENGTH_SHORT).show();
        }
    }
}
