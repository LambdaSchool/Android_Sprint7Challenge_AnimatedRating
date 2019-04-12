package com.rybarstudios.animatedrating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class CustomRating extends LinearLayout {

    private static final int MAX_RATING = 10;
    private static final int STARTING_RATING = 5;

    private int emptyStar, filledStar, maxRating, defaultRating;
    private ArrayList<CustomImage> imageViews;

    public CustomRating(Context context) {
        super(context);
        init(null);
    }

    public CustomRating(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomRating(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomRating(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        imageViews = new ArrayList<>();

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomRating);
        emptyStar =  typedArray.getResourceId(R.styleable.CustomRating_emptyStar, R.drawable.ic_launcher_background);
        filledStar =  typedArray.getResourceId(R.styleable.CustomRating_filledStar, R.drawable.ic_launcher_foreground);
        maxRating = typedArray.getInt(R.styleable.CustomRating_maxRating, MAX_RATING);
        defaultRating = typedArray.getInt(R.styleable.CustomRating_defaultRating, STARTING_RATING);
        typedArray.recycle();

        drawImage(maxRating);
        setAnimatedDrawable(defaultRating - 1);
    }

    private void drawImage(int images){
        removeAllViews();
        imageViews.clear();
        for(int i = 0; i < images; i++){
            final CustomImage imageView = new CustomImage(getContext());
            imageViews.add(imageView);
            imageView.setImageDrawable(getResources().getDrawable(emptyStar));
            imageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setAnimatedDrawable(imageViews.indexOf(imageView));
                }
            });
            addView(imageView);
        }
        setAnimatedDrawable(defaultRating - 1);
    }

    private void setAnimatedDrawable(int index){
        if(imageViews.get(index).isFilled()){
            for(int i = index + 1; i <= imageViews.size() - 1; ++i){
                if(imageViews.get(i).isFilled()){
                    imageViews.get(i).setImageDrawable(getResources().getDrawable(emptyStar));
                    animateImage(i, false);
                }
            }
        }else{
            for(int i = index; i >= 0; --i){
                if(!imageViews.get(i).isFilled()){
                    imageViews.get(i).setImageDrawable(getResources().getDrawable(filledStar));
                    animateImage(i, true);
                }
            }

        }
    }

    private void animateImage(int i, boolean filled) {
        Drawable drawable = imageViews.get(i).getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        imageViews.get(i).setFilled(filled);
    }

    public int getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(int maxRating) {
        this.maxRating = maxRating;
        drawImage(maxRating);
    }

    public int getDefaultRating() {
        return defaultRating;
    }

    public void setDefaultRating(int defaultRating) {
        this.defaultRating = defaultRating;
        setAnimatedDrawable(defaultRating - 1);
    }
}
