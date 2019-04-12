package com.vivekvishwanath.animatedrating.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.vivekvishwanath.animatedrating.R;

import java.util.ArrayList;

public class AnimatedRatingBar extends LinearLayout {

    private int maxRating, startingRating;
    private int emptySymbolId, filledSymbolId;
    private ArrayList<RatingSymbol> ratingSymbols;
    private final int DEFAULT_MAX_RATING = 10;
    private final int DEFAULT_STARTING_RATING = 5;
    private int currentRating = DEFAULT_STARTING_RATING;

    public AnimatedRatingBar(Context context) {
        super(context);
        init(null);
    }

    public AnimatedRatingBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public AnimatedRatingBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public AnimatedRatingBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.AnimatedRatingBar);
            maxRating = typedArray.getInt(R.styleable.AnimatedRatingBar_max_rating, DEFAULT_MAX_RATING);
            startingRating = typedArray.getInt(R.styleable.AnimatedRatingBar_starting_rating, DEFAULT_STARTING_RATING);
            emptySymbolId = typedArray.getResourceId(R.styleable.AnimatedRatingBar_empty_symbol, R.drawable.ic_launcher_foreground);
            filledSymbolId = typedArray.getResourceId(R.styleable.AnimatedRatingBar_filled_symbol, R.drawable.ic_launcher_background);
        }

        ratingSymbols = new ArrayList<>();

        for (int i = 1; i <= maxRating; i++) {
            final RatingSymbol ratingSymbol = new RatingSymbol(getContext());
            if (i <= startingRating) {
                ratingSymbol.setFilled(true);
                ratingSymbol.setImageResource(filledSymbolId);
            } else {
                ratingSymbol.setFilled(false);
                ratingSymbol.setImageResource(emptySymbolId);
            }
            ratingSymbols.add(ratingSymbol);
            addView(ratingSymbol);
            ratingSymbol.getLayoutParams().width = 50;
            ratingSymbol.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeRating(ratingSymbols.indexOf(ratingSymbol));
                }
            });
        }
    }

    public void changeRating(int index) {
        for (int i = 0; i < maxRating; i++) {
            if (i <= index) {
                ratingSymbols.get(i).setFilled(true);
                 if (ratingSymbols.get(i).getDrawable() instanceof AnimatedVectorDrawable && i > currentRating - 1) {
                    ratingSymbols.get(i).setImageResource(emptySymbolId);
                    ((AnimatedVectorDrawable) ratingSymbols.get(i).getDrawable()).start();
                } else {
                    ratingSymbols.get(i).setImageResource(filledSymbolId);
                }
            } else {
                ratingSymbols.get(i).setFilled(false);
                if (ratingSymbols.get(i).getDrawable() instanceof AnimatedVectorDrawable && i <= currentRating - 1) {
                    ratingSymbols.get(i).setImageResource(filledSymbolId);
                    ((AnimatedVectorDrawable) ratingSymbols.get(i).getDrawable()).start();
                } else {
                    ratingSymbols.get(i).setImageResource(emptySymbolId);
                }
            }
        }
        currentRating = index + 1;
    }

    public void setRating(int rating) {
        if (rating >= 0 && rating <= maxRating) {
            changeRating(rating - 1);
        }
    }

    public int getRating() {
        int count = 0;
        for (int i = 0; i < ratingSymbols.size(); i++) {
            if (ratingSymbols.get(i).isFilled())
                count++;
        }
        return count;
    }
}
