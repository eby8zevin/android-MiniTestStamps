package com.ahmadabuhasan.stamps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ahmadabuhasan.stamps.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnApaBole.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ApaBoleActivity.class)));
        binding.btnWeather.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, WeatherActivity.class)));
        binding.btnPalindrome.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PalindromeActivity.class)));
    }

    @Override
    public void onBackPressed() {
        if (backPressed + 1000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }
}