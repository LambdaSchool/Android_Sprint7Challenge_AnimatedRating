package com.joshuahalvorson.android_sprint7challenge_animatedrating;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomImageView extends android.support.v7.widget.AppCompatImageView {
    public boolean isFilled = false;

    public CustomImageView(Context context) {
        super(context);
        init(null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
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
