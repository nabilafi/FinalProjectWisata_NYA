package com.wisata_nya.mei.wisata_nyamalangraya.Maps;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.OWisata;
import com.wisata_nya.mei.wisata_nyamalangraya.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Double koorX,koorY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map
        // is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Intent i = getIntent();
        mMap = googleMap;
        koorX = Double.parseDouble(i.getStringExtra("koorX"));
        koorY = Double.parseDouble(i.getStringExtra("koorY"));


// Daftar Objek Wisata
        //Kota BATU

        LatLng Cangar = new LatLng( koorX, koorY);
        mMap.addMarker(new MarkerOptions().position(Cangar).title("Cangar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Cangar));

//        LatLng CobanTalun = new LatLng( -7.801620, 112.517895);
//        mMap.addMarker(new MarkerOptions().position(CobanTalun).title("CobanTalun"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(CobanTalun));
//
//        LatLng Selecta = new LatLng( -7.817994, 112.525225);
//        mMap.addMarker(new MarkerOptions().position(Selecta).title("Selecta"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(Selecta));
//
//        LatLng GoaPandawa = new LatLng( -7.851910, 112.501586);
//        mMap.addMarker(new MarkerOptions().position(GoaPandawa).title("Goa Pandawa"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(GoaPandawa));
//
//        LatLng Alun2Batu = new LatLng( -7.871175, 112.526940);
//        mMap.addMarker(new MarkerOptions().position(Alun2Batu).title("Alun-Alun Kota Batu"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(Alun2Batu));
//
//        LatLng MuseumAngkut = new LatLng( -7.878898, 112.520207);
//        mMap.addMarker(new MarkerOptions().position(MuseumAngkut).title("Museum Angkut / Jatim Park 2"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(MuseumAngkut));
//
//        LatLng MuseumBagong = new LatLng( -7.884027, 112.523739);
//        mMap.addMarker(new MarkerOptions().position(MuseumBagong).title("Museum Bagong"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(MuseumBagong));
//
//        LatLng JTP1 = new LatLng( -7.883912, 112.524781);
//        mMap.addMarker(new MarkerOptions().position(JTP1).title("Jatim Park 1"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(JTP1));
//
//        LatLng CobanRais = new LatLng( -7.911371, 112.520605);
//        mMap.addMarker(new MarkerOptions().position(CobanRais).title("Coban Rais"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(CobanRais));
//
//        LatLng BatuFlowerGarden = new LatLng( -7.911949, 112.518915);
//        mMap.addMarker(new MarkerOptions().position(BatuFlowerGarden).title("Batu Flower Garden Coban Rais"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(BatuFlowerGarden));
//
//        LatLng BNS = new LatLng( -7.896432, 112.534549);
//        mMap.addMarker(new MarkerOptions().position(BNS).title("Batu Night Spectacular"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(BNS));
//
//        LatLng PredatorFunPark = new LatLng( -7.913065, 112.548404);
//        mMap.addMarker(new MarkerOptions().position(PredatorFunPark).title("Predator Fun Park"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(PredatorFunPark));
//
//
//        LatLng JTP3 = new LatLng( -7.895984, 112.553311);
//        mMap.addMarker(new MarkerOptions().position(JTP3).title("Jatim Park 3"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(JTP3));
//
//        //Kota MALANG
//
//        LatLng malang = new LatLng(-7.946636, 112.615271);
//        mMap.addMarker(new MarkerOptions().position(malang).title("Office of Wisata_NYA Malang Raya"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(malang));
//
//        LatLng Sengkaling = new LatLng( -7.915283, 112.588905);
//        mMap.addMarker(new MarkerOptions().position(Sengkaling).title("Sengkaling"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(Sengkaling));
//
//        LatLng HawaiWaterPark = new LatLng( -7.923292, 112.658205);
//        mMap.addMarker(new MarkerOptions().position(HawaiWaterPark).title("Hawai Water Park"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(HawaiWaterPark));
//
//        LatLng Alun2Malang = new LatLng( -7.982610, 112.630852);
//        mMap.addMarker(new MarkerOptions().position(Alun2Malang).title("Alun-Alun Kota Malang"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(Alun2Malang));
//
//        LatLng TamanSlamet = new LatLng( -7.973674, 112.622452);
//        mMap.addMarker(new MarkerOptions().position(TamanSlamet).title("Taman Slamet Kota Malang"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(TamanSlamet));
//
//        LatLng Wendit = new LatLng( -7.952658, 112.673995);
//        mMap.addMarker(new MarkerOptions().position(Wendit).title("Wisata Wendit"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(Wendit));
//
//        LatLng TamanKrida = new LatLng( -7.942578, 112.622530);
//        mMap.addMarker(new MarkerOptions().position(TamanKrida).title("Taman Krida"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(TamanKrida));
//
//        LatLng TamanSinghaMerjosari = new LatLng( -7.944798, 112.603221);
//        mMap.addMarker(new MarkerOptions().position(TamanSinghaMerjosari).title("Taman Singha Merjosari"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(TamanSinghaMerjosari));
//
//        LatLng CandiBadut = new LatLng( -7.957684, 112.598545);
//        mMap.addMarker(new MarkerOptions().position(CandiBadut).title("Candi Badut"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(CandiBadut));
//
//        //Kabupaten Malang
//        LatLng CobanRondo = new LatLng( -7.884695, 112.477314);
//        mMap.addMarker(new MarkerOptions().position(CobanRondo).title("Coban Rondo"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(CobanRondo));
//
//        LatLng TamanKelinci = new LatLng( -7.851439, 112.493644);
//        mMap.addMarker(new MarkerOptions().position(TamanKelinci).title("Taman Kelinci"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(TamanKelinci));
//
//        LatLng WadukSelorejo = new LatLng( -7.877275, 112.361038);
//        mMap.addMarker(new MarkerOptions().position(WadukSelorejo).title("Waduk Selorejo"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(WadukSelorejo));
//
//        LatLng SumberPitu = new LatLng( -7.895330, 112.462151);
//        mMap.addMarker(new MarkerOptions().position(SumberPitu).title("Sumber Pitu"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(SumberPitu));
//
//        LatLng SumberPapat = new LatLng( -7.896241, 112.462343);
//        mMap.addMarker(new MarkerOptions().position(SumberPapat).title("Sumber Papat"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(SumberPapat));
//
//        LatLng SumberSiji = new LatLng( -7.895298, 112.460942);
//        mMap.addMarker(new MarkerOptions().position(SumberSiji).title("Sumber Siji"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(SumberSiji));
//
//        LatLng CobanBuntung = new LatLng( -7.893499, 112.457293);
//        mMap.addMarker(new MarkerOptions().position(CobanBuntung).title("Coban Buntung"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(CobanBuntung));
//
//        LatLng CafeSawah = new LatLng( -7.855844, 112.454929);
//        mMap.addMarker(new MarkerOptions().position(CafeSawah).title("Cafe Sawah"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(CafeSawah));
//
//        LatLng BukitAmpang = new LatLng( -7.852375, 112.458035);
//        mMap.addMarker(new MarkerOptions().position(BukitAmpang).title("Cafe Sawah"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(BukitAmpang));


    }
}
