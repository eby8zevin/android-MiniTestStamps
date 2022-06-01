package com.ahmadabuhasan.stamps.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ahmadabuhasan.stamps.BuildConfig;
import com.ahmadabuhasan.stamps.databinding.ActivityWeatherBinding;
import com.ahmadabuhasan.stamps.model.DailyItem;
import com.ahmadabuhasan.stamps.model.WeatherResponse;
import com.ahmadabuhasan.stamps.retrofit.ApiConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    ActivityWeatherBinding binding;

    public static String lat = "-6.2146";
    public static String lon = "106.8451";
    public static String exclude = "current,minutely,hourly,alerts";
    public static String metric = "metric";
    public static String AppId = BuildConfig.ApiWeather;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeatherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("API Weather");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvWeather.setLayoutManager(layoutManager);
        DividerItemDecoration did = new DividerItemDecoration(this, layoutManager.getOrientation());
        binding.rvWeather.addItemDecoration(did);

        getData();
    }

    private void getData() {
        showLoading(true);
        Call<WeatherResponse> client = ApiConfig.getApiService().getWeather(lat, lon, exclude, metric, AppId);
        client.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                showLoading(false);
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        setWeather(response.body().getDaily());
                    }
                } else {
                    if (response.body() != null) {
                        Log.e("TAG", "onFailure: " + response.body().getDaily());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    private void setWeather(List<DailyItem> daily) {
        ArrayList<String> list = new ArrayList<>();
        for (DailyItem day : daily) {
            String date = new SimpleDateFormat("E, dd MMM yyyy", Locale.ENGLISH).format(new Date(day.getDt() * 1000L));
            String temp = day.getTemp().getMax() + "°C";
            list.add(date + ": " + temp);
        }

        WeatherAdapter adapter = new WeatherAdapter(list);
        binding.rvWeather.setAdapter(adapter);
    }

    private void showLoading(Boolean isLoading) {
        if (isLoading) {
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}