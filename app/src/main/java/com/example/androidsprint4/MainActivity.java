package com.example.androidsprint4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.example.androidsprint4.HeartLifeGauge;

public class MainActivity extends AppCompatActivity {

    HeartLifeGauge hlg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hlg = findViewById(R.id.heart_gauge);
        hlg.setEmptyToFullDrawable(R.drawable.avd_heart_empty_to_full);

        Button addHeart = findViewById(R.id.button_increase);
        Button subHeart = findViewById(R.id.button_decrease);

        addHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hlg.addHeart();
            }
        });

        subHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hlg.reduceHeart();
            }
        });

    }
}
