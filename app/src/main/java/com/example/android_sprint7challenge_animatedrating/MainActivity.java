package com.example.android_sprint7challenge_animatedrating;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animatable {
    Context context;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getApplicationContext();
        setContentView(R.layout.activity_main);
        final SliderView sl=findViewById(R.id.slider_rate);
        final EditText et=findViewById(R.id.input_rating);
        Button bt=findViewById(R.id.button_rate);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sl.setRating(Integer.parseInt( et.getText().toString()));
                TextView tv=findViewById(R.id.text_result);
                tv.setText(sl.getStringRating());
                tv.invalidate();


            }
        });

        findViewById(R.id.button_attribute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText eta=findViewById(R.id.input_max);
                EditText etb=findViewById(R.id.input_starting);
                EditText etc=findViewById(R.id.input_filled);
                EditText etd=findViewById(R.id.input_empty);
                String str=eta.getText().toString();
                int i=Integer.parseInt(str);
                sl.setMaxRating(i);
                sl.setStartingRating(Integer.parseInt(etb.getText().toString()));
                sl.setStrEmpty(etd.getText().toString());
                sl.setStrFilled(etc.getText().toString());

            }
        });


    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
