package com.example.patrickjmartin.android_sprint7challenge_animatedrating.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.patrickjmartin.android_sprint7challenge_animatedrating.R;

public class RatingsView extends android.support.v7.widget.AppCompatImageView {

    public boolean isFull = false;

    public RatingsView(Context context) {
        super(context);
        init(null);
    }

    public RatingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RatingsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public boolean isFull(){
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    protected void init(AttributeSet attrs) {
    }

    



}


//        float mid = getWidth() / 2;
//        float min = Math.min(getWidth(), getHeight());
//        float fat = min / 17;
//        float half = min / 2;
//
//        bigPaint.setStrokeWidth(fat);
//        bigPaint.setStyle(Paint.Style.STROKE);
//
//        bigStar.moveTo(mid + half * 0.5f, half * 0.84f);
//        bigStar.lineTo(mid + half * 1.5f, half * 0.84f);
//        bigStar.lineTo(mid + half * 0.68f, half * 1.45f);
//        bigStar.lineTo(mid + half * 1.0f, half * 0.5f);
//        bigStar.lineTo(mid + half * 1.32f, half * 1.45f);
//        bigStar.lineTo(mid + half * 0.5f, half * 0.84f);