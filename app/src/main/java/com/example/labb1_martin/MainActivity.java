package com.example.labb1_martin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button refreshButton;
    private TextView viewContainer;
    private TextView temperatureView;
    private TextView windView;
    private TextView cloudView;
    private TextView rainView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshButton = findViewById(R.id.refreshButton);
        viewContainer = findViewById(R.id.weathercontainer);
        temperatureView = findViewById(R.id.temperature);
        windView = findViewById(R.id.windspeed);
        cloudView = findViewById(R.id.cloudiness);
        rainView = findViewById(R.id.rain);
        imageView = findViewById(R.id.weatherImage);
    }
}


//Hej Emil & Emil

//hahahahahaha


//Test Vestin
//Test Alfred
//Test Filip