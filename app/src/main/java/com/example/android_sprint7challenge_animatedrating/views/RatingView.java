package com.example.android_sprint7challenge_animatedrating.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.android_sprint7challenge_animatedrating.R;

public class RatingView extends View {
    protected Paint paint1;
    protected int maxRating, startingRating, emptySymbol, filledSymbol, currentRating, layoutWidth, xIncrement;
    protected Drawable drawableEmpty, drawableFilled;
    protected Rect drawableRect;


    public RatingView(Context context) {
        super(context);
        init(null);
    }

    public RatingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RatingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    public RatingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);

    }

    public void init(AttributeSet attrs) {
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        currentRating = 2;
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RatingView);
            maxRating = typedArray.getInt(R.styleable.RatingView_max_rating, 10);
            startingRating = typedArray.getInt(R.styleable.RatingView_starting_rating, 2);
            filledSymbol = typedArray.getResourceId(R.styleable.RatingView_empty_symbol, R.color.colorPrimaryDark);
            emptySymbol = typedArray.getResourceId(R.styleable.RatingView_filled_symbol, R.color.colorAccent);
            typedArray.recycle();
        }
        layoutWidth = getWidth();
        xIncrement = layoutWidth / maxRating;

        drawableEmpty = ContextCompat.getDrawable(getContext(), emptySymbol);
        drawableFilled = ContextCompat.getDrawable(getContext(), filledSymbol);
        drawableRect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        layoutWidth = getWidth();
        xIncrement = layoutWidth / maxRating;
        int xStart = 0;

        for (int i = 0; i < maxRating; ++i) {
            drawableRect.left = xStart;
            drawableRect.top = 0;
            drawableRect.right = xStart + xIncrement;
            drawableRect.bottom = 100;
            if (i <= currentRating) {
                drawableEmpty.setBounds(drawableRect);
                drawableEmpty.draw(canvas);

                if (drawableEmpty instanceof AnimationDrawable) {
                    ((AnimationDrawable) drawableEmpty).start();
                }
            } else {
                drawableFilled.setBounds(drawableRect);
                drawableFilled.draw(canvas);
                if (drawableFilled instanceof Animatable) {
                    ((Animatable) drawableFilled).start();
                }
            }
            xStart += xIncrement;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                layoutWidth = getWidth();
                xIncrement = layoutWidth / maxRating;
                currentRating = (int) (event.getX() / xIncrement);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    public int getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(int currentRating) {
        this.currentRating = currentRating;
        invalidate();
    }
}
