package com.joshuahalvorson.android_sprint7challenge_animatedrating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class CustomView extends LinearLayout {

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

    private void setAnimatedDrawable(int index){
        if(imageViews.get(index).isFilled()){
            for(int i = index + 1; i <= imageViews.size() - 1; i++){
                if(imageViews.get(i).isFilled()){
                    imageViews.get(i).setImageDrawable(getResources().getDrawable(emptyImage));
                    Drawable drawable = imageViews.get(i).getDrawable();
                    if(drawable instanceof Animatable){
                        ((Animatable) drawable).start();
                    }
                    imageViews.get(i).setFilled(false);
                }
            }
        }else{
            for(int i = index; i >= 0; i--){
                if(!imageViews.get(i).isFilled()){
                    imageViews.get(i).setImageDrawable(getResources().getDrawable(filledImage));
                    Drawable drawable = imageViews.get(i).getDrawable();
                    if(drawable instanceof Animatable){
                        ((Animatable) drawable).start();
                    }
                    imageViews.get(i).setFilled(true);
                }
            }

        }
    }

    protected void init(AttributeSet attrs){
        setOrientation(HORIZONTAL);
        imageViews = new ArrayList<>();

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);
        emptyImage =  typedArray.getResourceId(R.styleable.CustomView_emptyImage, R.drawable.ic_launcher_background);
        filledImage =  typedArray.getResourceId(R.styleable.CustomView_filledImage, R.drawable.ic_launcher_foreground);
        maxRating = typedArray.getInt(R.styleable.CustomView_maxRating, 5);
        startingRating = typedArray.getInt(R.styleable.CustomView_startingRating, 3);

        for(int i = 1; i <= maxRating; i++){
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
}
