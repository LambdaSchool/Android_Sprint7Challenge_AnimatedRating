package com.example.android_sprint7challenge_animatedrating;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TestingTag";
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final Drawable drawable = getDrawable(R.drawable.star_empty_to_full);
//        imageView = findViewById(R.id.image_view1);
//        imageView.setImageDrawable(drawable);
//
//        findViewById(R.id.button_set_rating).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "onClick: Button Clicked");
//                if (drawable instanceof Animatable) {
//                    ((Animatable) imageView.getDrawable()).start();
//                }
//            }
//        });

    }
}
