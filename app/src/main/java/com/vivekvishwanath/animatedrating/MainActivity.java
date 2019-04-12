package com.vivekvishwanath.animatedrating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vivekvishwanath.animatedrating.views.AnimatedRatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AnimatedRatingBar arb = findViewById(R.id.rating_bar);
        final EditText editText = findViewById(R.id.rating_entry);
        Button getRatingButton = findViewById(R.id.get_rating_button);
        getRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rating: " + Integer.toString(arb.getRating()),Toast.LENGTH_LONG).show();
            }
        });
        Button setRatingButton = findViewById(R.id.set_rating_button);
        setRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (editText.getText().toString().trim().length() > 0) {
                        int rating = Integer.parseInt(editText.getText().toString());
                        if (rating >= 0 && rating <= arb.getMaxRating())
                            arb.setRating(rating);
                    }
                } catch (NumberFormatException e) {}
            }
        });


    }
}
