package com.jakeesveld.sprint4_challenge;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class RatingsView extends LinearLayout {

    int maxStars, initialStars, fillStar, emptyStar;

    public RatingsView(Context context) {
        super(context);
        init(null);
    }

    public RatingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RatingsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public RatingsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attrs){
        if(attrs != null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RatingsView);
            maxStars = typedArray.getInt(R.styleable.RatingsView_max_stars, 10);
            initialStars = typedArray.getInt(R.styleable.RatingsView_initial_stars, 5);
            emptyStar = typedArray.getResourceId(R.styleable.RatingsView_empty_star, R.drawable.avd_anim_fill_empty);
            fillStar = typedArray.getResourceId(R.styleable.RatingsView_fill_star, R.drawable.avd_anim_empty_fill);

            typedArray.recycle();
        }
    }
}
