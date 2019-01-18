package com.example.customrating;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class CustomRatingView extends RatingBar {
    public CustomRatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomRatingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CustomRatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRatingView(Context context) {
        super(context);
    }
}
