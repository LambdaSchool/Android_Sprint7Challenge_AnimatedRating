package com.example.customstarrating;

import android.content.Context;
import android.content.res.TypedArray;
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
        init(null);
    }

    public RatingsLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RatingsLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public RatingsLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RatingsLayout);
            starNumberTotal = typedArray.getInteger(R.styleable.RatingsLayout_max_rating, 10);
            starRating = typedArray.getInteger(R.styleable.RatingsLayout_starting_rating, 3);
            typedArray.recycle();
        }

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
        if (starRating < starNumberTotal) starRating++;
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
        if (starRating > 0) starRating--;
    }

    private void refreshStars() {
        removeAllViews();
        for (int i = 0; i < starNumberTotal; ++i) {
            if (i < starRating) {
                addView(new StarRating(getContext(), 1));
            } else {
                addView(new StarRating(getContext(), 0));
            }
        }
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
        refreshStars();
    }
}
