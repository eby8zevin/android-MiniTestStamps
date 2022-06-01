package com.ahmadabuhasan.stamps.model;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@Keep
public class Temp {

    @SerializedName("max")
    private double max;

    public double getMax() {
        return max;
    }
}