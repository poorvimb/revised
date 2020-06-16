package com.example.excelreal;

public class Data {
    private String app_id;
    private String dev_id, hardware_serial, payload_raw;
    private int port;


    public Data( String payload_raw)
    {

        this.setPayload(payload_raw);
    }


    // getter and setter methods for payload field
    public String getPayload()  {
        String payload_rawP=payload_raw.substring(payload_raw.length()-4);// to get oly last four characters of the payload_raw data
        return payload_rawP;
    }

    public void setPayload(String payload_raw) {
        this.payload_raw = payload_raw;

    }


}
