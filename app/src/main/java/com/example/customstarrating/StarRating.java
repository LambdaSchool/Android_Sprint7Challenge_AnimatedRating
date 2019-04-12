package com.example.customstarrating;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class StarRating extends View {
    int starsAmount = 10;


    public StarRating(Context context) {
        super(context);
        init(context);
    }

    public StarRating(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public StarRating(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public StarRating(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    private void init(Context context) {
        Paint paint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (int i = 0; i < starsAmount; i++) {

        }



    }
}
