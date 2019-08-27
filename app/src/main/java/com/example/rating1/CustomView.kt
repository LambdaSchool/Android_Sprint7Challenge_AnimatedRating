package com.example.rating1

import android.content.ContentUris
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout



private const val MAX_RATING = 5



class RatingView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {



    val ratingSymbols = ArrayList<Int>(MAX_RATING)



    init {







        for (i in ratingSymbols) {
            ratingSymbols.add(R.drawable.star_empty)

        }



    }

}