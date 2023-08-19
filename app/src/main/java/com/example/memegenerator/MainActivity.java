package com.example.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        setupSpinner();
        handleGenerateBtn();
    }

    private void setupSpinner() {
        String[] templates = getResources().getStringArray(R.array.templates);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, templates);
        binding.templatesSp.setAdapter(adapter);
    }



    private void handleGenerateBtn() {
        binding.button.setOnClickListener(v -> {
            String memeUrl = generateMemeUrl(getTemplateName(), getTopText(), getBottomText());
            Intent intent = new Intent(this, MemeActivity.class);
            intent.putExtra(memeUrl, "URL");
            startActivity(intent);
        });
    }

    private String getBottomText() {
        return binding.editTextText3.getText().toString();
    }

    private String getTopText() {
        return binding.editTextText2.getText().toString();
    }

    private String getTemplateName() {
        return binding.templatesSp.getSelectedItem().toString();
    }

    private String generateMemeUrl(String template, String topText, String bottomText){
        return "https://apimeme.com/meme?meme="+template+"&top="+topText+"&bottom="+bottomText;
    }
}