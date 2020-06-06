package com.example.excelreal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class TeamsAdapter extends ArrayAdapter<Team> {

    Context context;
    private ArrayList<Team> teams;

    public TeamsAdapter(Context context, int textViewResourceId, ArrayList<Team> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.teams = items;
    }

    @Override
    public View getView(int  port, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.team, null);
        }
        Team o = teams.get(port);
        if (o != null) {
            //TextView app = (TextView) v.findViewById(R.id.appid);
            //TextView dev = (TextView) v.findViewById(R.id.devid);
           // TextView hardware = (TextView) v.findViewById(R.id.hardware);
           // TextView portP = (TextView) v.findViewById(R.id.portP);
            TextView payloadR = (TextView) v.findViewById(R.id.payload);


            //app.setText(String.valueOf(o.getApp_id()));
            //dev.setText(String.valueOf(o.getDev_id()));
            //hardware.setText(String.valueOf(o.getHardware_serial()));
            //portP.setText(String.valueOf(o.getPort()));
            payloadR.setText(String.valueOf(o.getPayload()));


        }
        return v;
    }
}
