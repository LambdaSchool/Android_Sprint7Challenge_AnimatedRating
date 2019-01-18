package com.example.customrating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class CustomRatingView extends AppCompatRatingBar {
    protected int maximum, starting, empty, filled;


    public CustomRatingView(Context context) {
        super(context);

       init(null);    }

    public CustomRatingView(Context context, AttributeSet attrs) {
        super(context, attrs);

       init(attrs);    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getStarting() {
        return starting;
    }

    public void setStarting(int starting) {
        this.starting = starting;
    }

    public int getEmpty() {
        return empty;
    }

    public void setEmpty(int empty) {
        this.empty = empty;
    }

    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }

    public CustomRatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void init(AttributeSet attrs){
        if (attrs != null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomRatingView);
            maximum = typedArray.getInt(R.styleable.CustomRatingView_maximum_rating, 5);
            starting = typedArray.getInt(R.styleable.CustomRatingView_starting_rating, 2);
            empty = typedArray.getResourceId(R.styleable.CustomRatingView_empty_symbol, R.color.colorAccent);
            filled = typedArray.getResourceId(R.styleable.CustomRatingView_fill_symbol, R.color.colorPrimary);
            typedArray.recycle();
        }
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RatingBar ratingBar;
    }
}
