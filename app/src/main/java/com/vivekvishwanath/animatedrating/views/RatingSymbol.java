package com.vivekvishwanath.animatedrating.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RatingSymbol extends android.support.v7.widget.AppCompatImageView {

    private boolean isFilled;

    public RatingSymbol(Context context) {
        super(context);
    }

    public RatingSymbol(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RatingSymbol(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void init() {
        isFilled = false;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }


}
