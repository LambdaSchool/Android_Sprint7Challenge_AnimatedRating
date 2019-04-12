package com.example.androidsprint4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HeartLifeGauge extends LinearLayout {
    int sizeOfHearts, displayWidth;
    ImageView[] heartArr;
    public HeartLifeGauge(Context context) {
        super(context);
        init();
    }

    public HeartLifeGauge(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeartLifeGauge(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public HeartLifeGauge(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        displayWidth  = displayMetrics.widthPixels;
        int numOfMaxHearts = 10;
        int sizeOfStartingFullHearts = 3;
        sizeOfHearts = displayWidth/numOfMaxHearts;
        heartArr = new ImageView[numOfMaxHearts];
        boolean isStartingHeartsSet = false;

        for(int i = 0; i < heartArr.length; ++i){
            if(!isStartingHeartsSet){
            for(int j = 0; j < sizeOfStartingFullHearts-1; j++)
            {
                heartArr[i] = new ImageView(getContext());
                heartArr[i].setImageResource(R.drawable.ic_full_heart_container);
                heartArr[i].requestLayout();
                heartArr[i].setLayoutParams(new LayoutParams(sizeOfHearts,sizeOfHearts));
                this.addView(heartArr[i]);
                i++;
            }
            isStartingHeartsSet=true;}
            heartArr[i] = new ImageView(getContext());
            heartArr[i].setImageResource(R.drawable.ic_empty_heart_container);
            heartArr[i].requestLayout();
            heartArr[i].setLayoutParams(new LayoutParams(sizeOfHearts,sizeOfHearts));
            this.addView(heartArr[i]);
        }
    }

    public static void emptyToFull(int position){

    }

    public static void fullToEmpty(int position){

    }

    public static void updateViews(){

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
    }
}
