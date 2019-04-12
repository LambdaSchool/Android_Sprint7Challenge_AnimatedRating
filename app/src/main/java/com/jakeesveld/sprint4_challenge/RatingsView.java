package com.jakeesveld.sprint4_challenge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RatingsView extends LinearLayout {

    int maxStars, initialStars, fillStar, emptyStar;

    public RatingsView(Context context) {
        super(context);
        init(null);
    }

    public RatingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RatingsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public RatingsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.RatingsView);
            maxStars = typedArray.getInt(R.styleable.RatingsView_max_stars, 10);
            initialStars = typedArray.getInt(R.styleable.RatingsView_initial_stars, 5);
            emptyStar = typedArray.getResourceId(R.styleable.RatingsView_empty_star, R.drawable.avd_anim_fill_empty);
            fillStar = typedArray.getResourceId(R.styleable.RatingsView_fill_star, R.drawable.avd_anim_empty_fill);

            typedArray.recycle();
            drawStars(true);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int halfway = getWidth() / 2;
        if (event.getX() < halfway) {
            initialStars -= 1;
        } else {
            initialStars += 1;
        }
        drawStars(false);
        return false;
    }

    public void setStars(int maxStars, int initialStars) {
        this.maxStars = maxStars;
        this.initialStars = initialStars;
        drawStars(true);
    }

    public void drawStars(boolean firstDraw) {
        removeAllViews();
        if (initialStars > maxStars) {
            initialStars = maxStars;
        } else if (initialStars < 0) {
            initialStars = 0;
        }

        for (int i = 0; i <= maxStars; i++) {
            final ImageView star = new ImageView(getContext());
            if (i <= initialStars) {
                star.setImageDrawable(getResources().getDrawable(fillStar));
                if (star.getDrawable() instanceof Animatable) {
                    ((Animatable) star.getDrawable()).start();
                }
            } else if (i == initialStars) {
                star.setImageDrawable(getResources().getDrawable(emptyStar));
                if (star.getDrawable() instanceof Animatable) {
                    ((Animatable) star.getDrawable()).start();
                }
            } else {
                star.setImageDrawable(getResources().getDrawable(R.drawable.star_empty));

            }
            addView(star);
        }


    }
}
