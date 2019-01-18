package com.joshuahalvorson.android_sprint7challenge_animatedrating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

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

    private void setAnimatedDrawable(List<CustomImageView> imageViews, CustomImageView imageView, int filledImage, int emptyImage){
        if(imageView.isFilled()){
            for(int i = imageViews.indexOf(imageView) + 1; i <= imageViews.size() - 1; i++){
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
            for(int i = imageViews.indexOf(imageView); i >= 0; i--){
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
        final List<CustomImageView> imageViews = new ArrayList<>();

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);

        final int emptyImage =  typedArray.getResourceId(R.styleable.CustomView_emptyImage, R.drawable.ic_launcher_background);
        final int filledImage =  typedArray.getResourceId(R.styleable.CustomView_filledImage, R.drawable.ic_launcher_foreground);
        int maxRating = typedArray.getInt(R.styleable.CustomView_maxRating, 5);
        int startingRating = typedArray.getInt(R.styleable.CustomView_startingRating, 3);

        for(int i = 1; i <= maxRating; i++){
            final CustomImageView imageView = new CustomImageView(getContext());
            imageViews.add(imageView);
            imageView.setImageDrawable(getResources().getDrawable(emptyImage));
            imageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    setAnimatedDrawable(imageViews, imageView, filledImage, emptyImage);
                    Log.i("SAdas", Integer.toString(imageViews.indexOf(imageView)));
                }
            });
            addView(imageView);
        }

        setAnimatedDrawable(imageViews, imageViews.get(startingRating - 1), filledImage, emptyImage);
    }
}
