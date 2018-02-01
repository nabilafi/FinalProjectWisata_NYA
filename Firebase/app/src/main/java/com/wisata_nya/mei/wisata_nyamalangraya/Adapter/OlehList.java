package com.wisata_nya.mei.wisata_nyamalangraya.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wisata_nya.mei.wisata_nyamalangraya.Model.Oleh;
import com.wisata_nya.mei.wisata_nyamalangraya.R;

import java.util.List;

/**
 * Created by mei on 1/28/2018.
 */

public class OlehList extends ArrayAdapter<Oleh>

{
    private Activity context;
    private List<Oleh> olehList;

    public OlehList(Activity context, List<Oleh> olehList)
    {
        super(context, R.layout.list_layout_oleh, olehList);
        this.context = context;
        this.olehList = olehList;
//        this.aboutUsList = aboutUsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout_oleh, null, true);

        TextView tvViewOlehNama = (TextView) listViewItem.findViewById(R.id.tViewNamaOleh);
        TextView tvViewOlehHarga = (TextView) listViewItem.findViewById(R.id.tViewHargaOleh);
        TextView tvViewOlehVarian = (TextView) listViewItem.findViewById(R.id.tViewVarianOleh);
        TextView tvViewOlehKeterangan = (TextView) listViewItem.findViewById(R.id.tViewKeteranganOleh);

        Oleh oleh = olehList.get(position);

        tvViewOlehNama.setText(oleh.getOlehNama());
        tvViewOlehHarga.setText(oleh.getOlehHarga());
        tvViewOlehVarian.setText(oleh.getOlehVarian());
        tvViewOlehKeterangan.setText(oleh.getOlehKeterangan());

        return listViewItem;
    }

}


