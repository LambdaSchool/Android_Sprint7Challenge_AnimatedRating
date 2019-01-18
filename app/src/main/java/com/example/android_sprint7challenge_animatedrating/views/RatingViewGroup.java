package com.example.android_sprint7challenge_animatedrating.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.android_sprint7challenge_animatedrating.*;


public class RatingViewGroup extends FrameLayout {
    public RatingViewGroup(@NonNull Context context) {
        super(context);
        init(null);
    }

    public RatingViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RatingViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public RatingViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        final View inflatedView = inflate(getContext(), R.layout.rating_view_group_layout, null);
        addView(inflatedView);
        ((RatingView) findViewById(R.id.rating_view)).setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
    }
}
