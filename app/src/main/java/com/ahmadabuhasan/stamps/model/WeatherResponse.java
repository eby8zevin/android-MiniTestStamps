package com.ahmadabuhasan.stamps.model;

import androidx.annotation.Keep;

import java.util.List;

import com.google.gson.annotations.SerializedName;

@Keep
public class WeatherResponse {

    @SerializedName("daily")
    private List<DailyItem> daily;

    public List<DailyItem> getDaily() {
        return daily;
    }
}