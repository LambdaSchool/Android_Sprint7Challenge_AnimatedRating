package com.example.android_sprint7challenge_animatedrating.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.android_sprint7challenge_animatedrating.R;

public class RatingView extends View {
    protected Paint paint1;
    protected int maxRating, startingRating, emptySymbol, filledSymbol, currentRating, layoutWidth, xIncrement;
    protected Bitmap bitmapEmpty, bitmapFilled;
    float touchXStart, touchXDistance;

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
            emptySymbol = typedArray.getResourceId(R.styleable.RatingView_empty_symbol, R.color.colorPrimaryDark);
            filledSymbol = typedArray.getResourceId(R.styleable.RatingView_filled_symbol, R.color.colorAccent);
            typedArray.recycle();
            bitmapEmpty = BitmapFactory.decodeResource(getResources(), emptySymbol);
            bitmapFilled = BitmapFactory.decodeResource(getResources(), filledSymbol);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        layoutWidth = getWidth();
        xIncrement = layoutWidth / maxRating;
        int xStart = 0;

        for (int i = 0; i < maxRating; ++i) {
            if (i <= currentRating) {
                canvas.drawBitmap(bitmapFilled, xStart, 0, paint1);
            } else {
                canvas.drawBitmap(bitmapEmpty, xStart, 0, paint1);
            }
            xStart += xIncrement;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchXStart = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                layoutWidth = getWidth();
                xIncrement = layoutWidth / maxRating;
                currentRating = (int) (event.getX()/xIncrement);
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
