package com.ahmadabuhasan.stamps.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.ahmadabuhasan.stamps.databinding.ActivityApaBoleBinding;

import java.util.ArrayList;
import java.util.Objects;

public class ApaBoleActivity extends AppCompatActivity {

    ActivityApaBoleBinding binding;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityApaBoleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("AppBole");

        ArrayList<String> list = new ArrayList<>();

        for (i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                Log.d("", "ApaBole");
                list.add("ApaBole");
            } else if (i % 3 == 0) {
                Log.d("", "Apa");
                list.add("Apa");
            } else if (i % 5 == 0) {
                Log.d("", "Bole");
                list.add("Bole");
            } else {
                Log.d("", String.valueOf(i));
                list.add("" + i);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        binding.resultList.setAdapter(adapter);
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