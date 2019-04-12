package com.example.israel.sprint4;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class RatingView extends LinearLayout {

    public static final int MIN_RATING = 1;

    public RatingView(Context context) {
        super(context);

        init(null);
    }

    public RatingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    private void init(AttributeSet attrs) {
        setOrientation(LinearLayout.HORIZONTAL);

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RatingView);
            maxRating = typedArray.getInteger(R.styleable.RatingView_maxRating, MIN_RATING);
            rating = typedArray.getInteger(R.styleable.RatingView_rating, MIN_RATING);
            // clamp
            if (rating < MIN_RATING) {
                rating = MIN_RATING;
            } else if (rating > maxRating) {
                rating = maxRating;
            }

            emptySymbol = R.drawable.avd_star_filled_to_empty;//typedArray.getInteger(R.styleable.RatingView_emptySymbol, 0);
            filledSymbol = R.drawable.avd_star_empty_to_filled;//typedArray.getInteger(R.styleable.RatingView_filledSymbol, 0);
        } else {
            maxRating = MIN_RATING;
            rating = MIN_RATING;
        }

        for (int i = 0; i < maxRating; ++i) {
            SymbolView symbolView = new SymbolView(getContext());
            int imageResId = rating > i ? filledSymbol : emptySymbol;
            symbolView.setImageDrawable(getContext().getDrawable(imageResId));
            addView(symbolView);
            symbolViews.add(symbolView);
        }
    }

    private int maxRating;
    private int rating;
    private int emptySymbol;
    private int filledSymbol;
    private ArrayList<SymbolView> symbolViews = new ArrayList<>();

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//
//    }

    public void setMaxRating(int maxRating) {
        if (maxRating == this.maxRating || maxRating < MIN_RATING) {
            return;
        }

        if (maxRating < this.maxRating) { // decrease symbol



        } else { // increase symbol

        }
    }

    public void setRating(int rating) {

    }

    private class SymbolView extends AppCompatImageView {

        public SymbolView(Context context) {
            super(context);

        }


    }
}
