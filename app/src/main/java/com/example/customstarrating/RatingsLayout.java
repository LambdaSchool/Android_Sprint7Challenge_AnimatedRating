package com.example.customstarrating;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class RatingsLayout extends LinearLayout {

    int starNumberTotal = 10;
    int starRating = 5;

    public RatingsLayout(Context context) {
        super(context);
        init();
    }

    public RatingsLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RatingsLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public RatingsLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        for (int i = 0; i < starNumberTotal; ++i) {
            if (i < starRating) {
                addView(new StarRating(getContext(), 1));
            } else {
                addView(new StarRating(getContext(), 0));
            }
        }

    }


    public void addStar() {
        removeAllViews();
        starRating++;
        for (int i = 0; i < starNumberTotal; ++i) {
            if (i < starRating) {
                if (i == starRating - 1) {
                    addView(new StarRating(getContext(), 2));
                } else
                    addView(new StarRating(getContext(), 1));
            } else {
                addView(new StarRating(getContext(), 0));
            }
        }
    }

    public void removeStar() {
        removeAllViews();
        for (int i = 0; i < starNumberTotal; ++i) {
            if (i < starRating) {
                if (i == starRating - 1) {
                    addView(new StarRating(getContext(), 3));
                } else
                    addView(new StarRating(getContext(), 1));
            } else {
                addView(new StarRating(getContext(), 0));
            }
        }
        starRating--;
    }
}
