package com.example.android_sprint7challenge_animatedrating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomView extends LinearLayout {
    public static int currentRating ;

    private static final int DEFAULT_MAX_RATING = 5;
    private static final int DEFAULT_STARTING_RATING = 1;

    private int empty, filled, maxRating, initialRating;
    public  List<CustomStarImage> starViews;

// all preMade methods required for implementation

    public CustomView(Context context) {
    super(context);
    init(null);
}

    public CustomView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
}

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
    super(context, attrs, defStyleAttr);
    init(attrs);
}
   //TODO: for future use of app, determine if this method will be used. Otherwise delete during polish
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
    super(context, attrs, defStyleAttr, defStyleRes);
    init(attrs);
}

// getters for future use of the app
    public int getInitialRating() {
        return initialRating;
    }
    public int getMaxRating() {
        return maxRating;
    }

// setters for current use of the app :)
    public void setInitialRating(int initialRating) {
        this.initialRating = initialRating;
        setAnimatedDrawable(initialRating - 1);
    }
    public void setMaxRating(int maxRating) {
        this.maxRating = maxRating;
        drawImage(maxRating);
    }

//method to draw the image while running through the arrayList, as well as creating the onClickListener for changing the rating
    //TODO: change onClick to onTouch and add some more functionality when using in an app.
    private void drawImage(int images){
        removeAllViews();
        starViews.clear();
        for(int i = 1; i <= images; i++){
            final CustomStarImage imageView = new CustomStarImage(getContext());
            starViews.add(imageView);
            imageView.setImageDrawable(getResources().getDrawable(empty));
            imageView.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    setAnimatedDrawable(starViews.indexOf(imageView));

                }
            });
            addView(imageView);
        }
        setAnimatedDrawable(initialRating - 1);
    }
// method used to animate the drawn images based on the boolean contained in the object (isFilled)
    //TODO: for implementation purposes as far as expanding, add more data to each star for increased functionality
    private void setAnimatedDrawable(int index){
        //iterating through the index created for views and animating each star
        //4 mvp handling animagedVectorDrawable images and animating as changed.
        if(starViews.get(index).isFilled()){
            for(int i = index + 1; i <= starViews.size() - 1; i++){
                if(starViews.get(i).isFilled()){
                    starViews.get(i).setImageDrawable(getResources().getDrawable(empty));
                    animateImage(i, false);
                    Toast.makeText(getContext(), "Rating is: "+((index+1))+" out of "+ (starViews.size()), Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            for(int i = index; i >= 0; i--){
                if(!starViews.get(i).isFilled()){
                    starViews.get(i).setImageDrawable(getResources().getDrawable(filled));
                    currentRating = i+1;
                    animateImage(i, true);
                    Toast.makeText(getContext(), "Rating is: "+((index +1))+" out of "+ (starViews.size()), Toast.LENGTH_SHORT).show();

                }
            }

        }
    }

    //4 mvp handling animatedVectorDrawable images and animating as changed.
    private void animateImage(int i, boolean filled) {
        Drawable drawable = starViews.get(i).getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        starViews.get(i).setFilled(filled);
    }
    //standard init , initializing and attaching all components.
    protected void init(AttributeSet attrs){
        //adding programmatic attributes to the view
        setOrientation(HORIZONTAL);
        starViews = new ArrayList<>();

        //grabbing all info from the resource files
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);
        empty =  typedArray.getResourceId(R.styleable.CustomView_emptyImage, R.drawable.ic_launcher_background);
        filled =  typedArray.getResourceId(R.styleable.CustomView_filledImage, R.drawable.ic_launcher_foreground);
        maxRating = typedArray.getInt(R.styleable.CustomView_maxRating, DEFAULT_MAX_RATING);
        initialRating = typedArray.getInt(R.styleable.CustomView_initialRating, DEFAULT_STARTING_RATING);
        typedArray.recycle();

        //creating the image with however many stars the user wants to have (maxRating), defaulting to my constant variables
        drawImage(maxRating);
        setAnimatedDrawable(initialRating - 1);
    }
}
