package com.example.android_sprint7challenge_animatedrating;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.android_sprint7challenge_animatedrating.views.RatingView;

public class MainActivity extends AppCompatActivity {

    RatingView ratingView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingView = findViewById(R.id.rating_view);
        editText = findViewById(R.id.edit_rating);
        editText.setText(String.valueOf(ratingView.getCurrentRating()));

        findViewById(R.id.button_set_rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingView.setCurrentRating(Integer.parseInt(editText.getText().toString()));
            }
        });

    }
}
