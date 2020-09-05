package com.example.customstarrating;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class RatingsLayout extends LinearLayout {

    private int starNumberTotal = 10;
    private int starRating = 5;
    private int stateModifier = 0;

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
            boolean modify = typedArray.getBoolean(R.styleable.RatingsLayout_alternate_stars, false);
            if (modify) stateModifier = 4;
            typedArray.recycle();
        }

        for (int i = 0; i < starNumberTotal; ++i) {
            if (i < starRating) {
                addView(new StarRating(getContext(), 1 + stateModifier));
            } else {
                addView(new StarRating(getContext(), 0 + stateModifier));
            }
        }

    }


    public void addStar() {
        removeAllViews();
        if (starRating < starNumberTotal) starRating++;
        for (int i = 0; i < starNumberTotal; ++i) {
            if (i < starRating) {
                if (i == starRating - 1) {
                    addView(new StarRating(getContext(), 2 + stateModifier));
                } else
                    addView(new StarRating(getContext(), 1 + stateModifier));
            } else {
                addView(new StarRating(getContext(), 0 + stateModifier));
            }
        }
    }

    public void removeStar() {
        removeAllViews();
        for (int i = 0; i < starNumberTotal; ++i) {
            if (i < starRating) {
                if (i == starRating - 1) {
                    addView(new StarRating(getContext(), 3 + stateModifier));
                } else
                    addView(new StarRating(getContext(), 1 + stateModifier));
            } else {
                addView(new StarRating(getContext(), 0 + stateModifier));
            }
        }
        if (starRating > 0) starRating--;
    }

    private void refreshStars() {
        removeAllViews();
        for (int i = 0; i < starNumberTotal; ++i) {
            if (i < starRating) {
                addView(new StarRating(getContext(), 1 + stateModifier));
            } else {
                addView(new StarRating(getContext(), 0 + stateModifier));
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
