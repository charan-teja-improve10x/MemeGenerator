package com.example.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.memegenerator.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleGenerateBtn();
    }

    private void showImage(String imageUrl) {
        Picasso.get().load(imageUrl).into(binding.imageView);
    }

    private void handleGenerateBtn() {
        binding.button.setOnClickListener(v -> {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
            String memeUrl = generateMemeUrl(getTemplateName(), getTopText(), getBottomText());
            showImage(memeUrl);
        });
    }

    private String getBottomText() {
        return binding.editTextText3.getText().toString();
    }

    private String getTopText() {
        return binding.editTextText2.getText().toString();
    }

    private String getTemplateName() {
        return binding.editTextText.getText().toString();
    }

    private String generateMemeUrl(String template, String topText, String bottomText){
        return "https://apimeme.com/meme?meme="+template+"&top="+topText+"&bottom="+bottomText;
    }
}