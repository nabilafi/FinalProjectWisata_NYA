package com.wisata_nya.mei.wisata_nyamalangraya.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wisata_nya.mei.wisata_nyamalangraya.Model.OWisata;
import com.wisata_nya.mei.wisata_nyamalangraya.R;

import java.util.List;

/**
 * Created by mei on 1/20/2018.
 */

public class OWisataList  extends ArrayAdapter<OWisata> {
    private Activity context;
    private List<OWisata> owisataList;

    public OWisataList(Activity context, List<OWisata> owisataList)
    {
        super(context, R.layout.list_layout_owisata, owisataList);
        this.context = context;
        this.owisataList = owisataList;
//        this.kontakList = kontakList;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout_owisata, null, true);

        TextView tViewName = (TextView) listViewItem.findViewById(R.id.tViewName);
//        TextView tViewDeskripsi = (TextView) listViewItem.findViewById(R.id.tViewDeskripsi);
//        TextView tViewKota = (TextView) listViewItem.findViewById(R.id.tViewKota);

        OWisata oWisata = owisataList.get(position);

        tViewName.setText(oWisata.getOwisataName());
//        tViewDeskripsi.setText((oWisata.getOwisataDeskripsi()));
//        tViewKota.setText(oWisata.getOwisataKota());

        return listViewItem;



    }

}
