package com.example.customratingbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

class RatingBarView (context: Context, attrs: AttributeSet?): LinearLayout(context, attrs) {

    constructor(context: Context): this(context, null)

    var rating:Int=1

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatingBarView)
        val textWeight = typedArray.getFloat(R.styleable.RatingBarView_layout_weight, 8f)
        val textSize = typedArray.getDimension(R.styleable.RatingBarView_textSize, 12f)
        typedArray.recycle()

        val textLayoutParams = LayoutParams(0, LayoutParams.WRAP_CONTENT, textWeight)
        val ratingBarLayout = LayoutInflater.from(context).inflate(R.layout.rating_bar_layout, this, false) as LinearLayout

       orientation =  VERTICAL
        addView(ratingBarLayout)

    }



}