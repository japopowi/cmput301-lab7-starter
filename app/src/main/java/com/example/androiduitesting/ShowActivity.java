package com.example.androiduitesting;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * ShowActivity displays the name of a selected city and a back button.
 */
public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView cityNameText = findViewById(R.id.text_city_name);
        Button backButton = findViewById(R.id.button_back);

        //get city name
        String cityName = getIntent().getStringExtra("city_name");
        cityNameText.setText(cityName);

        // back button
        backButton.setOnClickListener(v -> finish());
    }
}
