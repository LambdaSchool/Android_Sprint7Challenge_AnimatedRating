package com.example.israel.sprint4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
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

            emptySymbol = typedArray.getResourceId(R.styleable.RatingView_emptySymbol, 0);
            filledSymbol = typedArray.getResourceId(R.styleable.RatingView_filledSymbol, 0);
        } else {
            maxRating = MIN_RATING;
            rating = MIN_RATING;
        }

        for (int i = 0; i < maxRating; ++i) {
            SymbolView symbolView = new SymbolView(getContext(), i);
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

    public int getRating() {
        return rating;
    }

    // TODO
    public void setMaxRating(int maxRating) {
        if (maxRating == this.maxRating || maxRating < MIN_RATING) {
            return;
        }

        if (maxRating < this.maxRating) { // decrease symbol

        } else { // increase symbol

        }
    }

    public void setRating(int rating) {
        if (rating == this.rating) {
            return;
        }

        int oldRating = this.rating;
        if (rating < MIN_RATING) {
            this.rating = MIN_RATING;
        } else if (rating > maxRating) {
            this.rating = maxRating;
        } else {
            this.rating = rating;
        }

        if (this.rating < oldRating) { // empty the symbol
            for (int i = oldRating - 1; i > this.rating - 1; --i) {
                SymbolView symbolView = symbolViews.get(i);

                symbolView.setImageDrawable(getContext().getDrawable(emptySymbol));
                Drawable drawable = symbolView.getDrawable();
                if (drawable instanceof Animatable) {
                    Animatable animatable = (Animatable)drawable;
                    animatable.start();
                }
            }
        } else { // fill the symbol
            for (int i = oldRating; i < this.rating; ++i) {
                SymbolView symbolView = symbolViews.get(i);

                symbolView.setImageDrawable(getContext().getDrawable(filledSymbol));
                Drawable drawable = symbolView.getDrawable();
                if (drawable instanceof Animatable) {
                    Animatable animatable = (Animatable)drawable;
                    animatable.start();
                }
            }
        }
    }

    private class SymbolView extends AppCompatImageView {

        public SymbolView(Context context, final int i) {
            super(context);

            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    RatingView.this.setRating(i + 1);
                }
            });
        }

    }
}
