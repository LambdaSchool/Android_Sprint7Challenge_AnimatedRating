package com.example.israel.sprint4;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout mainConstraintLayout = findViewById(R.id.constraint_layout_main);
        RatingView ratingView = new RatingView(this);
        ratingView.setMaxRating(6);
        ratingView.setRating(5);
        ratingView.setEmptySymbol(R.drawable.avd_star_filled_to_empty);
        ratingView.setFilledSymbol(R.drawable.avd_star_empty_to_filled);
        mainConstraintLayout.addView(ratingView);

    }
}
