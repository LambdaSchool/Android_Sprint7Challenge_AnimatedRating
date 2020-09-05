package com.example.customstarrating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView addButton = findViewById(R.id.button_plus);
        ImageView minusButton = findViewById(R.id.button_minus);
        final RatingsLayout ratingsLayout = findViewById(R.id.star_rating_layout);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingsLayout.addStar();
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingsLayout.removeStar();
            }
        });
    }
}
