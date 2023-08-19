package com.example.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.memegenerator.databinding.ActivityMemeBinding;
import com.squareup.picasso.Picasso;

public class MemeActivity extends AppCompatActivity {

    private ActivityMemeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String title = "Memes";
        getSupportActionBar().setTitle(title);
        String imageUrl = getIntent().getStringExtra("URL");
        showImage(imageUrl);
    }

    private void showImage(String imageUrl) {
        Picasso.get().load(imageUrl).into(binding.memeIv);
    }
}