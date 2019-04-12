package com.rybarstudios.animatedrating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomRating customRating = findViewById(R.id.custom_rating);
        customRating.setMaxRating(5);
        customRating.setDefaultRating(1);
    }
}
