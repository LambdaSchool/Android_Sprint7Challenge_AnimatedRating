package com.example.android_sprint7challenge_animatedrating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.i-2.ii mvp goal, showing that you can programatically set number of views (max rating) and initial rating(initialRating)
        //3 mvp goal allows activity code to set or get rating
        CustomView customView = findViewById(R.id.custom_view);
        customView.setMaxRating(5);
        customView.setInitialRating(4);
    }
}
