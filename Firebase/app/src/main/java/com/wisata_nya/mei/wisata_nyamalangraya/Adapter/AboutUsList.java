package com.wisata_nya.mei.wisata_nyamalangraya.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wisata_nya.mei.wisata_nyamalangraya.Model.AboutUs;
import com.wisata_nya.mei.wisata_nyamalangraya.R;

import java.util.List;

/**
 * Created by mei on 1/17/2018.
 */

public class AboutUsList extends ArrayAdapter<AboutUs>

    {
        private Activity context;
        private List<AboutUs> aboutUsList;

    public AboutUsList(Activity context, List<AboutUs> aboutUsList)
        {
            super(context, R.layout.list_layout_aboutus, aboutUsList);
            this.context = context;
            this.aboutUsList = aboutUsList;
            this.aboutUsList = aboutUsList;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout_aboutus, null, true);

        TextView tvViewVers = (TextView) listViewItem.findViewById(R.id.tViewVers);
        TextView tvViewDesc = (TextView) listViewItem.findViewById(R.id.tViewDesc);

        AboutUs aboutUs = aboutUsList.get(position);

        tvViewVers.setText(aboutUs.getVersion());
        tvViewDesc.setText(aboutUs.getDesc());

        return listViewItem;
    }

    }

