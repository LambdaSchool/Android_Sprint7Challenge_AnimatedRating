package com.earthdefensesystem.android_sprint7challenge_animatedrating.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.earthdefensesystem.android_sprint7challenge_animatedrating.R;

import java.util.ArrayList;

public class RatingViewHolder extends LinearLayout {

    private ArrayList<StarRatingView> view;
    private int emptyStar, fullStar, initialStars, maxStars, emptyAnimation, fillAnimation;


    public RatingViewHolder(Context context) {
        super(context);
        init(null);
    }

    public RatingViewHolder(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RatingViewHolder(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public RatingViewHolder(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attrs){
        if (attrs != null){
            TypedArray typedArray = getContext().obtainStyledAttributes
                    (attrs, R.styleable.RatingViewHolder);
            emptyAnimation = typedArray.getResourceId
                    (R.styleable.RatingViewHolder_empty_animation, R.drawable.ic_launcher_background);
            fillAnimation = typedArray.getResourceId
                    (R.styleable.RatingViewHolder_fill_animation, R.drawable.ic_launcher_foreground);
            fullStar = typedArray.getResourceId(R.styleable.RatingViewHolder_full_star, R.drawable.ic_default_full_star);
            emptyStar = typedArray.getResourceId(R.styleable.RatingViewHolder_empty_star, R.drawable.ic_default_empty_star);
            initialStars = typedArray.getInt(R.styleable.RatingViewHolder_initial_rating, 3);
            maxStars = typedArray.getInt(R.styleable.RatingViewHolder_max_rating, 10);

            typedArray.recycle();
        }
    }
}
