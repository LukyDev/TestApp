package com.lukdev.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.lukdev.test.databinding.ActivityFullScreenActivyBinding;

public class FullScreenActivity extends AppCompatActivity {

    ActivityFullScreenActivyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullScreenActivyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String url = getIntent().getStringExtra("urlGif");
        Glide.with(this)
                .asGif()
                .load(url)
                .into(binding.fullImage);
    }

}