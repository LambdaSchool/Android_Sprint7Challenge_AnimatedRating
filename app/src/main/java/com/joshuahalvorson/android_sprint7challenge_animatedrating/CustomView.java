package com.joshuahalvorson.android_sprint7challenge_animatedrating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class CustomView extends LinearLayout {
    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    protected void init(AttributeSet attrs){
        setOrientation(HORIZONTAL);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);

        int emptyImage =  typedArray.getResourceId(R.styleable.CustomView_emptyImage, R.drawable.ic_launcher_background);
        int filledImage =  typedArray.getResourceId(R.styleable.CustomView_filledImage, R.drawable.ic_launcher_foreground);
        int maxRating = typedArray.getInt(R.styleable.CustomView_maxRating, 5);
        int startingRating = typedArray.getInt(R.styleable.CustomView_startingRating, 3);

        if(startingRating < maxRating){
            for(int i = 1; i <= startingRating; i++){
                CustomImageView imageView = new CustomImageView(getContext());
                imageView.setImageDrawable(getResources().getDrawable(emptyImage));
                addView(imageView);
            }
        }
    }
}
