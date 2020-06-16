package com.example.excelreal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
public class DataAdapter extends ArrayAdapter<Data> {

    Context context;
    private ArrayList<Data> dataD;

    public DataAdapter(Context context, int textViewResourceId, ArrayList<Data> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.dataD = items;
    }

     // view of data is managed using this method. The way the data has to be structured is described. Initiates the xml layout file
    @Override
    public View getView(int  port, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.data, null);
        }
        Data o = dataD.get(port);
        if (o != null) {
            TextView payloadR = (TextView) v.findViewById(R.id.payload); // enable the text view to display the data
            payloadR.setText(String.valueOf(o.getPayload())); //convert data to string

        }
        return v;
    }
}
