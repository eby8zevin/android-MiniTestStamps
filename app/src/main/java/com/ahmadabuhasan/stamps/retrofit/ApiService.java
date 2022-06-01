package com.ahmadabuhasan.stamps.retrofit;

import com.ahmadabuhasan.stamps.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("data/2.5/onecall?")
    Call<WeatherResponse> getWeather(@Query("lat") String lat,
                                     @Query("lon") String lon,
                                     @Query("exclude") String exclude,
                                     @Query("units") String metric,
                                     @Query("appid") String app_id);
}