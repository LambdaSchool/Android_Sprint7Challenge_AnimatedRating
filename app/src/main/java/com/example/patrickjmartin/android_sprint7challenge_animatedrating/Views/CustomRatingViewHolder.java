package com.example.patrickjmartin.android_sprint7challenge_animatedrating.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;


import com.example.patrickjmartin.android_sprint7challenge_animatedrating.R;

import java.util.ArrayList;

public class CustomRatingViewHolder extends FrameLayout {

    private ArrayList<RatingsView> views;
    private int max_stars, initial_stars, empty_star, full_star;

    public CustomRatingViewHolder(@NonNull Context context) {
        super(context);

    }

    public CustomRatingViewHolder(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomRatingViewHolder(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomRatingViewHolder(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attrs) {

        views = new ArrayList<>();

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomRatingViewHolder);
            max_stars = typedArray.getInt(R.styleable.CustomRatingViewHolder_max_stars, 10);
            initial_stars = typedArray.getInt(R.styleable.CustomRatingViewHolder_initial_stars, 2);
            empty_star = typedArray.getResourceId(R.styleable.CustomRatingViewHolder_empty_star, R.color.colorPrimaryDark);
            full_star = typedArray.getResourceId(R.styleable.CustomRatingViewHolder_full_star, R.color.colorAccent);
            typedArray.recycle();

            for (int i = 0; i < max_stars; i++) {
                final RatingsView star = new RatingsView(getContext());
                views.add(star);
                if (i < initial_stars) {
                    star.setFull(true);
                    star.setImageDrawable(getResources().getDrawable(empty_star));
                }

                star.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });




            }


        }
    }

}
