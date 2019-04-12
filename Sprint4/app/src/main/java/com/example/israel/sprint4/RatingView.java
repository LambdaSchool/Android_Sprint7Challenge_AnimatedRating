package com.example.israel.sprint4;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class RatingView extends ViewGroup {

    public RatingView(Context context) {
        super(context);
    }

    public RatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private class SymbolView extends AppCompatImageView {

        public SymbolView(Context context) {
            super(context);
        }

        public SymbolView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }


    }
}
