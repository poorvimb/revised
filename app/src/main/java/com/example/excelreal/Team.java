package com.example.excelreal;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class Team {
    private String app_id;
    private String dev_id, hardware_serial, payload_raw;
    private int port;


    public Team(String app_id, String dev_id, String hardware_serial, int port, String payload_raw)
    {
        this.setApp_id(app_id);
        this.setDev_id(dev_id);
        this.setHardware_serial(hardware_serial);
        this.setPort(port);
        this.setPayload(payload_raw);
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getDev_id() {

        return dev_id;
    }

    public void setDev_id(String dev_id) {
        this.dev_id = dev_id;
    }

    public String getHardware_serial() {
        return hardware_serial;
    }

    public void setHardware_serial(String hardware_serial) {
        this.hardware_serial = hardware_serial;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPayload()  {
       return payload_raw;
    }

    public void setPayload(String payload_raw) {
        this.payload_raw = payload_raw;

    }


}

