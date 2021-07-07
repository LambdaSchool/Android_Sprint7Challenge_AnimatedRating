package com.rybarstudios.animatedrating;

import android.content.Context;
import android.util.AttributeSet;

public class CustomImage extends android.support.v7.widget.AppCompatImageView {
    public boolean isFilled = false;


    public CustomImage(Context context) {
        super(context);
        init(null);
    }

    public CustomImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomImage(Context context, AttributeSet attrs, int defStyleAttr) {
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
