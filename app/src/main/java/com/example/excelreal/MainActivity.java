package com.example.excelreal;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private String  payload_raw;


    private static final String DEBUG_TAG = "HttpExample";
    ArrayList<Data> Data1 = new ArrayList<Data>(); //creating an array list for data
    ListView listview;   // list view for displaying as a list of items
    Button btnDownload;



     //Initializes the button "download page" and the list view.
     // It  establishes a connection and also checks for network connection
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);
        btnDownload = (Button) findViewById(R.id.btnDownload);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            btnDownload.setEnabled(true);
        } else {
            btnDownload.setEnabled(false);
        }
    }

    // on click of button it extracts the data from the webpage
    public void buttonClickHandler(View view) {
        new DownloadWebpageTask(new AsyncResult() {
            @Override
            public void onResult(JSONObject object) {
                processJson(object);
            }
        }).execute("https://spreadsheets.google.com/tq?key=1gGyJS2phIcmiTEEUdUhOsyqekEudBue_NtNkjKsTQrQ");


    }

    // gets the columns of excel which have been converted to Json in the form of an array
    private void processJson(JSONObject object) {

        try {
            JSONArray rows = object.getJSONArray("rows");


            //for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(rows.length()-1);
                JSONArray columns = row.getJSONArray("c");
                String payload_raw = columns.getJSONObject(4).getString("v");

                Data d1 = new Data( payload_raw);
                Data1.add(d1);

           // }

            final DataAdapter adapter = new DataAdapter(this, R.layout.data, Data1);
            listview.setAdapter(adapter); //The list of items is displayed using listview


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}





