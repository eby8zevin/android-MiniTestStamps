package com.ahmadabuhasan.stamps.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ahmadabuhasan.stamps.R;
import com.ahmadabuhasan.stamps.databinding.ActivityPalindromeBinding;

import java.util.Objects;

public class PalindromeActivity extends AppCompatActivity {

    private ActivityPalindromeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPalindromeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.palindrome);

        binding.button.setOnClickListener(view -> checkPalindrome(binding.editTextTextInputWord.getText().toString().trim()));
    }

    private void checkPalindrome(String value) {

        String temp = "";
        for (int i = value.length() - 1; i >= 0; i--) {
            temp = temp + value.charAt(i);
            Log.d("", "" + temp);
        }

        for (int i = 0; i < value.length(); i++) {
            int indexEnd = value.length() - i - 1;

            if (value.charAt(i) == value.charAt(indexEnd)) {
                binding.textViewStatus.setText(R.string.palindrome);
            } else {
                binding.textViewStatus.setText(R.string.not_palindrome);
            }
            //Log.d("", "" + value.charAt(i));
            Log.d("", "" + value.charAt(indexEnd));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}