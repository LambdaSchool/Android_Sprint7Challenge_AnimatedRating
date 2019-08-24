package com.example.android_sprint7challenge_animatedrating;

import android.content.Context;
import android.util.AttributeSet;

public class CustomStarImage extends android.support.v7.widget.AppCompatImageView {
    public boolean isFilled = false;

    public CustomStarImage(Context context) {
        super(context);
        init(null);
    }

    public CustomStarImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomStarImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public void init(AttributeSet attrs){

    }
}
