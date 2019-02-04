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


    private int emptyStar, filledStar, maxStar, startingStar;
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
        return startingStar;
    }

    public void setStartingRating(int startingRating) {
        this.startingStar = startingRating;
        setAnimatedDrawable(startingRating - 1);
    }

    public int getMaxRating() {
        return maxStar;
    }

    public void setMaxRating(int maxRating) {
        this.maxStar = maxRating;
        drawImage(maxRating);
    }

    private void drawImage(int images) {
        removeAllViews();
        imageViews.clear();

        for (int i = 1; i <= images; i++) {
            final CustomImageView imageView = new CustomImageView(getContext());
            imageViews.add(imageView);
            imageView.setImageDrawable(getResources().getDrawable(emptyStar));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setAnimatedDrawable(imageViews.indexOf(imageView));
                }
            });
            addView(imageView);
        }
        setAnimatedDrawable(startingStar - 1);
    }

    private void setAnimatedDrawable(int index) {
        if (imageViews.get(index).isFilled()) {
            for (int i = index + 1; i <= imageViews.size() - 1; i++) {
                if (imageViews.get(i).isFilled()) {
                    imageViews.get(i).setImageDrawable(getResources().getDrawable(emptyStar));
                    animateImage(i, false);
                }
            }
        } else {
            for (int i = index; i >= 0; i--) {
                if (!imageViews.get(i).isFilled()) {
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

    protected void init(AttributeSet attrs) {
        setOrientation(HORIZONTAL);
        imageViews = new ArrayList<>();


        setAnimatedDrawable(startingStar - 1);
    }

    public void setStars(int newMaxStars, int newStartingStars) {

        removeAllViews();
        CustomView.clear();

        maxStar = newMaxStars;
        startingStar = newStartingStars;
        filledStar = newStartingStars;

        if (newMaxStars < newStartingStars) {
            newStartingStars = newMaxStars;
        }

        for (int i = 0; i < newMaxStars; i++) {
            final CustomView star = new CustomView(getContext());
            CustomImageView.add(filledStarstar);
            if (i < newStartingStars) {
                star.setFull(true);
                star.setImageDrawable(getResources().getDrawable(animated));
            } else {
                star.setFull(false);
                star.setImageDrawable(getResources().getDrawable(animated));
            }

            Drawable drawable = star.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }

            addView(star);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {


        int touchLocation = (int) ev.getX();

        if (touchLocation < filledStar) {
            animated(filledStar - 1);
            Toast.makeText(getContext(), "Decrease Star Rating", Toast.LENGTH_SHORT).show();
        } else {
            animated(startingStar+ 1);
            Toast.makeText(getContext(), "Increase Star Rating ", Toast.LENGTH_SHORT).show();
        }


        return super.onInterceptTouchEvent(ev);
    }
}
