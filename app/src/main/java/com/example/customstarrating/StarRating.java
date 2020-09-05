package com.example.customstarrating;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class StarRating extends android.support.v7.widget.AppCompatImageView {
    public static final int STAR_1_EMPTY_TO_FULL = R.drawable.star1_empty_to_full;
    public static final int STAR_1_FULL_TO_EMPTY = R.drawable.star1_full_to_empty;
    public static final int STAR_2_EMPTY_TO_FULL = R.drawable.star2_empty_to_fill2;
    public static final int STAR_2_EMPTY = R.drawable.star2_blank;
    public static final int STAR_2_FULL_TO_EMPTY = R.drawable.star2_full_to_empty;

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


    //style 1 states
    //0= Empty, 1=Full, 2=filling, 3=emptying
    //style 2 states
    //4= Empty, 5=Full, 6=filling, 7=emptying

    private void init(Context context, int state) {
        switch(state) {
            case 0:
                setImageResource(STAR_1_EMPTY_TO_FULL);
                break;
            case 1:
                setImageResource(STAR_1_FULL_TO_EMPTY);
                break;
            case 2:
                setImageResource(STAR_1_EMPTY_TO_FULL);
                fillStar();
                break;
            case 3:
                setImageResource(STAR_1_FULL_TO_EMPTY);
                emptyStar();
                break;
            case 4:
                setImageResource(STAR_2_EMPTY);
                break;
            case 5:
                setImageResource(STAR_2_FULL_TO_EMPTY);
                break;
            case 6:
                setImageResource(STAR_2_EMPTY_TO_FULL);
                fillStar();
                break;
            case 7:
                setImageResource(STAR_2_FULL_TO_EMPTY);
                emptyStar();
                break;
        }

    }

    private void fillStar() {
        Drawable drawable = getDrawable();
        ((AnimatedVectorDrawable)drawable).start();
    }

    private void emptyStar() {
        Drawable drawable = getDrawable();
        ((AnimatedVectorDrawable)drawable).start();
    }

}
