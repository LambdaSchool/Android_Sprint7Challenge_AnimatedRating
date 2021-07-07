package com.example.patrickjmartin.android_sprint7challenge_animatedrating;

import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import com.example.patrickjmartin.android_sprint7challenge_animatedrating.Views.CustomRatingViewHolder;
import com.example.patrickjmartin.android_sprint7challenge_animatedrating.Views.RatingsView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomRatingViewHolder viewHolder = findViewById(R.id.star_custom_view);
        viewHolder.setStars(12, 8);

    }
}

//    final ImageView imageView = findViewById(R.id.imageView2);
//        final Animation fadeout = new AlphaAnimation(1, 0);
//        final Animation fadein = new AlphaAnimation(0, 1);
//
//
//        fadeout.setDuration(500);
//        fadein.setDuration(500);
//
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (imageView.getVisibility() == View.VISIBLE) {
//                    imageView.setVisibility(View.INVISIBLE);
//                    imageView.startAnimation(fadeout);
//                } else {
//                    imageView.setVisibility(View.VISIBLE);
//                    imageView.startAnimation(fadein);
//                }
//
//            }
//        });

