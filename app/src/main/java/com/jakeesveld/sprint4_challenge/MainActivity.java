package com.jakeesveld.sprint4_challenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editMax, editInitial;
    Button buttonChange;
    RatingsView ratingsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMax = findViewById(R.id.edit_max_stars);
        editInitial = findViewById(R.id.edit_initial_stars);
        buttonChange = findViewById(R.id.button_change_rating);
        ratingsView = findViewById(R.id.ratings_view);

        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newMax = Integer.parseInt(editMax.getText().toString());
                int newInitial = Integer.parseInt(editInitial.getText().toString());

                ratingsView.setStars(newMax, newInitial);
            }
        });
    }
}
