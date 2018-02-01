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
 * Created by mei on 1/29/2018.
 */

public class FrontOlehList extends ArrayAdapter<Oleh> {
    private Activity context;
    private List<Oleh> olehList;

    public FrontOlehList(Activity context, List<Oleh> olehList)
    {
        super(context, R.layout.list_front_oleh, olehList);
        this.context = context;
        this.olehList = olehList;
//        this.wisataList = wisataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_front_oleh, null, true);

        TextView tViewNamaOleh = (TextView) listViewItem.findViewById(R.id.tViewNamaOleh);
        TextView tViewHargaOleh = (TextView) listViewItem.findViewById(R.id.tViewHargaOleh);
        TextView tViewVarianOleh = (TextView) listViewItem.findViewById(R.id.tViewVarianOleh);
        TextView tViewKeteranganOleh = (TextView) listViewItem.findViewById(R.id.tViewKeteranganOleh);

        Oleh oleh = olehList.get(position);

        tViewNamaOleh.setText(oleh.getOlehNama());
        tViewHargaOleh.setText(oleh.getOlehHarga());
        tViewVarianOleh.setTag(oleh.getOlehVarian());
        tViewKeteranganOleh.setText(oleh.getOlehKeterangan());
        return listViewItem;
    }
}

