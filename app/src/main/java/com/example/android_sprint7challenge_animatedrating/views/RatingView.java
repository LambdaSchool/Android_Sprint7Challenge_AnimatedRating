package com.example.android_sprint7challenge_animatedrating.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.android_sprint7challenge_animatedrating.R;

public class RatingView extends View {
    protected Paint paint1;
    protected int max_rating, starting_rating, empty_symbol, filled_symbol;
    protected Bitmap bitmapEmpty, bitmapFilled;

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
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RatingView);
            max_rating = typedArray.getInt(R.styleable.RatingView_max_rating, 10);
            starting_rating = typedArray.getInt(R.styleable.RatingView_starting_rating, 2);
            empty_symbol = typedArray.getResourceId(R.styleable.RatingView_empty_symbol, R.color.colorPrimaryDark);
            filled_symbol = typedArray.getResourceId(R.styleable.RatingView_filled_symbol, R.color.colorAccent);
            typedArray.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bitmapEmpty = BitmapFactory.decodeResource(getResources(), empty_symbol);
        canvas.drawBitmap(bitmapEmpty,0,0,paint1);
    }
}
