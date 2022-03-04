package com.lukdev.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        String name = getIntent().getStringExtra("nameGif");

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView.setText(name);
        Glide.with(this)
                .asGif()
                .load(url)
                .into(binding.fullImage);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}