package com.example.customrating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomRatingView customRatingView = findViewById(R.id.customView);
        customRatingView.setMaximum(5);
        customRatingView.setStarting(2);
    }
}
