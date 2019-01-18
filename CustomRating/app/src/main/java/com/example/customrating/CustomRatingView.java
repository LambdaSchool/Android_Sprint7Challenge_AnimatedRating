package com.example.customrating;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class CustomRatingView extends AppCompatRatingBar {

    public CustomRatingView(Context context) {
        super(context);
    }

    public CustomRatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RatingBar ratingBar;
    }
}
