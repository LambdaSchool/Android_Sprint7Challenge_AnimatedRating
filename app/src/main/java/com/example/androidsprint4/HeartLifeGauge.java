package com.example.androidsprint4;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HeartLifeGauge extends LinearLayout {
    int displayWidth, currentHealth, maxHearts, startingHearts,counter,heartSize;
    float X,diffX;
    ImageView[] heartArr;
    Drawable emptyToFullDrawable;
    Drawable fullToEmptyDrawable;

    public HeartLifeGauge(Context context) {
        super(context);
        init(null);
    }

    public HeartLifeGauge(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public HeartLifeGauge(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public HeartLifeGauge(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void setMaxHearts(int maxHearts) {
        this.maxHearts = maxHearts;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                X = event.getX();
                invalidate();
                counter = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                diffX = event.getX() - X;
                counter = (int) (diffX/heartSize);
                if((X-event.getX() > 0)&&counter>1){
                    invalidate();
                }
                if((X-event.getX() < 0)&&(heartSize/Math.abs(diffX))>1){
                    invalidate();
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                counter = Math.abs(counter);
                if(diffX>0){
                    for(int i = 0; i < counter; i++){
                        addHeart();
                        Toast.makeText(getContext(), "Added : " + String.valueOf(counter) + " Hearts", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    for(int i = 0; i < counter; i++){
                        reduceHeart();
                        Toast.makeText(getContext(), "Reduced : " + String.valueOf(counter) + " Hearts", Toast.LENGTH_SHORT).show();
                    }
                }
                invalidate();
                break;

        }

        return true;
    }

    private void init(AttributeSet attrs) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        maxHearts = 10;
        startingHearts = 3;

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.HeartLifeGauge);
            startingHearts = typedArray.getInt(R.styleable.HeartLifeGauge_starting_health, 3);
            maxHearts = typedArray.getInt(R.styleable.HeartLifeGauge_max_health, 10);
        }

        displayWidth = displayMetrics.widthPixels;
        fullToEmptyDrawable = getResources().getDrawable(R.drawable.avd_heart_full_to_empty);
        emptyToFullDrawable = getResources().getDrawable(R.drawable.avd_heart_empty_to_full);
        currentHealth = startingHearts;
        heartSize = displayWidth / maxHearts;
        heartArr = new ImageView[maxHearts];


        boolean isStartingHeartsSet = false;

        for (int i = 0; i < heartArr.length; ++i) {
            if (!isStartingHeartsSet) {
                for (int j = 0; j < startingHearts; j++) {
                    heartArr[i] = new ImageView(getContext());
                    heartArr[i].setImageResource(R.drawable.ic_full_heart_container);
                    // heartArr[i].requestLayout();
                    heartArr[i].setLayoutParams(new LayoutParams(heartSize, heartSize));
                    this.addView(heartArr[i]);
                    i++;
                }
                isStartingHeartsSet = true;
            }
            heartArr[i] = new ImageView(getContext());
            heartArr[i].setImageResource(R.drawable.ic_empty_heart_container);
            // heartArr[i].requestLayout();
            heartArr[i].setLayoutParams(new LayoutParams(heartSize, heartSize));
            this.addView(heartArr[i]);
        }
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void addHeart() {
        if (currentHealth < maxHearts) {
            heartArr[currentHealth].setImageDrawable(emptyToFullDrawable);
            if (heartArr[currentHealth].getDrawable() instanceof Animatable) {
                ((Animatable) heartArr[currentHealth].getDrawable()).start();
            }
            currentHealth++;
            invalidate();
        }
    }

    public void reduceHeart() {
        if (currentHealth > 0) {
            heartArr[currentHealth - 1].setImageDrawable(fullToEmptyDrawable);
            if (heartArr[currentHealth - 1].getDrawable() instanceof Animatable) {
                Animatable animatable = (Animatable) heartArr[currentHealth - 1].getDrawable();
                animatable.start();
            }
            currentHealth--;
            invalidate();
        }
    }

    public void updateViews() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        displayWidth = this.getWidth() / maxHearts;
        for (int i = 0; i < heartArr.length; ++i) {
            heartArr[i].requestLayout();
            heartArr[i].setLayoutParams(new LayoutParams(heartSize, heartSize));
        }

        super.onDraw(canvas);
    }
}
