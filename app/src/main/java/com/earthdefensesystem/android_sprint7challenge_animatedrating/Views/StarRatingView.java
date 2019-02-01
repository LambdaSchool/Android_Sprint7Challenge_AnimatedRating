package com.earthdefensesystem.android_sprint7challenge_animatedrating.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class StarRatingView extends android.support.v7.widget.AppCompatImageView {

    public boolean isFull = false;

    public StarRatingView(Context context) {
        super(context);
        init(null);
    }

    public StarRatingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public StarRatingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    public boolean isFull(){
        return isFull;
    }

    public void setFull(boolean full){
        isFull = full;
    }

    protected void init(AttributeSet attrs){

    }
}
