package com.example.customstarrating;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class StarRating extends android.support.v7.widget.AppCompatImageView {
    int starsAmount = 10;


    public StarRating(Context context, int state) {
        super(context);
        init(context, state);
    }

    public StarRating(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, 0);
    }

    public StarRating(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, 0);
    }


    private void init(Context context, int state) {//0= Empty, 1=Full, 2=filling, 3=emptying
        switch(state) {
            case 0:
                setImageResource(R.drawable.avd_star_empty_to_full);
                break;
            case 1:
                setImageResource(R.drawable.avd_star_full_to_empty);
                break;
            case 2:
                setImageResource(R.drawable.avd_star_empty_to_full);
                fillStar();
                break;
            case 3:
                setImageResource(R.drawable.avd_star_full_to_empty);
                emptyStar();
                break;

        }

    }

    public void fillStar() {
        Drawable drawable = getDrawable();
        ((AnimatedVectorDrawable)drawable).start();
    }

    public void emptyStar() {
        Drawable drawable = getDrawable();
        ((AnimatedVectorDrawable)drawable).start();
    }

}
