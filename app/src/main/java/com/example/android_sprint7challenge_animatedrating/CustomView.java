package com.example.android_sprint7challenge_animatedrating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomView extends LinearLayout {

    private static final int DEF_MAX_RATING = 10;
    private static final int DEF_STARTING_RATING = 1;
    private int emptyImage, filledImage, maxRating, startingRating;
    private List<CustomImageView> imageViews;




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

    public int getStartingRating() {
        return startingRating;
    }

    public void setStartingRating(int startingRating) {
        this.startingRating = startingRating;
        setAnimatedDrawable(startingRating - 1);
    }

    public int getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(int maxRating) {
        this.maxRating = maxRating;
        drawImage(maxRating);
    }



    protected void init(AttributeSet attrs) {
        setOrientation(HORIZONTAL);
        imageViews = new ArrayList<>();

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);
        emptyImage = typedArray.getResourceId(R.styleable.CustomView_emptyStar, R.drawable.empty_color2);
        filledImage = typedArray.getResourceId(R.styleable.CustomView_filledStar, R.drawable.animated);
        maxRating = typedArray.getInt(R.styleable.CustomView_maxStar, DEF_MAX_RATING);
        startingRating = typedArray.getInt(R.styleable.CustomView_startingStar, DEF_STARTING_RATING);
        drawImage(maxRating);
        typedArray.recycle();
        setAnimatedDrawable(startingRating - 1);

    }



    private void drawImage(int images){
        removeAllViews();
        imageViews.clear();

        for(int i = 1; i < maxRating; i++){
            final CustomImageView imageView = new CustomImageView(getContext());



            imageViews.add(imageView);
            imageView.setImageDrawable(getResources().getDrawable(emptyImage));
            imageView.setOnClickListener(new View.OnClickListener(){



                @Override
                public void onClick(View v) {
                    setAnimatedDrawable(imageViews.indexOf(imageView));
                }
            });

            addView(imageView);
        }
        setAnimatedDrawable(startingRating - 1);
    }


    private void setAnimatedDrawable(int index){
        if(imageViews.get(index).isFilled()){
            for(int i = index + 1; i <= imageViews.size() - 1; i++){
                if(imageViews.get(i).isFilled()){
                    imageViews.get(i).setImageDrawable(getResources().getDrawable(emptyImage));
                    animateImage(i, false);
                }
            }

        }else{
            for(int i = index; i >= 0; i--){
                if(!imageViews.get(i).isFilled()){
                    imageViews.get(i).setImageDrawable(getResources().getDrawable(filledImage));
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

        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {


            int touchLocation = (int) ev.getX();



            return super.onInterceptTouchEvent(ev);


    }

}