package com.example.customrating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;

public class CustomRatingView extends LinearLayout {
    public static final int DEFAULT_MAX_RATING = 5;
    public static final int DEFAULT_START_RATING = 2;

    protected Drawable  empty, filled;
    protected int maximum, starting, userRating;


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

    public CustomRatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void init(AttributeSet attrs){
        if (attrs != null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomRatingView);
            maximum = typedArray.getInt(R.styleable.CustomRatingView_maximum_rating, DEFAULT_MAX_RATING);
            starting = typedArray.getInt(R.styleable.CustomRatingView_starting_rating, DEFAULT_START_RATING);
            empty = typedArray.getDrawable(R.styleable.CustomRatingView_empty_symbol);
            filled = typedArray.getDrawable(R.styleable.CustomRatingView_fill_symbol);
            typedArray.recycle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        drawRatingView();
    }

    private void drawRatingView(){
        if (this.getChildCount() == 0){
            createRatingView();
        }else {
            updateRatingView();
        }
    }

    private void updateRatingView() {
        for (int i = 0; i < maximum ; i++) {
            ImageView imageView = (ImageView) this.getChildAt(i);
            imageView.setImageDrawable(i + 1 <= userRating ? filled:empty);

        }
    }

    private void createRatingView() {
        for (int i = 0; i < DEFAULT_MAX_RATING; i++) {
            final ImageView imageView = new ImageView(getContext());
            int tagValue = i + 1;
            imageView.setTag(tagValue);
            imageView.setImageDrawable(empty);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    userRating = (int) v.getTag();
                    drawRatingView();

                }
            });
            addView(imageView);

        }
    }
}
