package com.example.android_sprint7challenge_animatedrating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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



    }
}
