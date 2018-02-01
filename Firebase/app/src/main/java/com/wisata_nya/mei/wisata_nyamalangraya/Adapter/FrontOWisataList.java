package com.wisata_nya.mei.wisata_nyamalangraya.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.wisata_nya.mei.wisata_nyamalangraya.DetailWisata;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.OWisata;
import com.wisata_nya.mei.wisata_nyamalangraya.R;

import java.util.List;

/**
 * Created by mei on 1/20/2018.
 */

public class FrontOWisataList extends ArrayAdapter<OWisata> {
    private Activity context;
    private List<OWisata> oWisataList;

    public FrontOWisataList(Activity context, List<OWisata> oWisataList)
    {
        super(context, R.layout.list_front_owisata, oWisataList);

        this.context = context;
        this.oWisataList = oWisataList;
//        this.wisataList = wisataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_front_owisata, null, true);

        TextView tvViewName = (TextView) listViewItem.findViewById(R.id.tViewName);
//        TextView tvViewDeskripsi = (TextView) listViewItem.findViewById(R.id.tViewDeskripsi);
//        TextView tViewKota = (TextView) listViewItem.findViewById(R.id.tViewKota);

        OWisata oWisata = oWisataList.get(position);

        tvViewName.setText(oWisata.getOwisataName());
//        tvViewDeskripsi.setText(oWisata.getOwisataDeskripsi());
//        tViewKota.setText(oWisata.getOwisataKota());

        return listViewItem;
    }
}
