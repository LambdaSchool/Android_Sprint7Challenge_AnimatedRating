package com.vivekvishwanath.animatedrating.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class AnimatedRatingBar extends LinearLayout {

    private int maxRating, startingRating;
    private int emptySymbolId, filledSymbolId;
    private ArrayList<RatingSymbol> ratingSymbols;

    public AnimatedRatingBar(Context context) {
        super(context);
    }

    public AnimatedRatingBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimatedRatingBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AnimatedRatingBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
