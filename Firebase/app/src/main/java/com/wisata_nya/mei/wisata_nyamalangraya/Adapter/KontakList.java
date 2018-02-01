package com.wisata_nya.mei.wisata_nyamalangraya.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wisata_nya.mei.wisata_nyamalangraya.CreateKontak;
import com.wisata_nya.mei.wisata_nyamalangraya.Model.Kontak;
import com.wisata_nya.mei.wisata_nyamalangraya.R;

import java.util.List;

/**
 * Created by mei on 1/17/2018.
 */

public class KontakList extends ArrayAdapter<Kontak> {
    private Activity context;
    private List<Kontak> kontakList;

    public KontakList(Activity context, List<Kontak> kontakList)
    {
        super(context, R.layout.list_layout_kontak, kontakList);
        this.context = context;
        this.kontakList = kontakList;
//        this.kontakList = kontakList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout_kontak, null, true);

        TextView tvViewKet = (TextView) listViewItem.findViewById(R.id.tViewKet);
        TextView tvViewSosmed = (TextView) listViewItem.findViewById(R.id.tViewSosmed);

        Kontak kontak = kontakList.get(position);

        tvViewKet.setText(kontak.getKontakKet());
        tvViewSosmed.setText(kontak.getKontakSosmed());

        return listViewItem;



    }

}
