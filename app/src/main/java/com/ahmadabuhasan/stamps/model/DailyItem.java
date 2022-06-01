package com.ahmadabuhasan.stamps.model;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@Keep
public class DailyItem {

    @SerializedName("dt")
    private int dt;

    @SerializedName("temp")
    private Temp temp;

    public int getDt() {
        return dt;
    }

    public Temp getTemp() {
        return temp;
    }
}