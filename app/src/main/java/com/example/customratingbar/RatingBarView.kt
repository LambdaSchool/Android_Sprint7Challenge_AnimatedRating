package com.example.customratingbar

import android.content.Context
import android.graphics.drawable.Animatable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.rating_bar_layout.view.*

class RatingBarView (context: Context, attrs: AttributeSet?): LinearLayout(context, attrs) {

    constructor(context: Context): this(context, null)

    var rating:Int=1
    var name:String=""

    init {
        //val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatingBarView)
       // val textWeight = typedArray.getFloat(R.styleable.RatingBarView_layout_weight, 8f)
      //  val textSize = typedArray.getDimension(R.styleable.RatingBarView_textSize, 12f)
      //  typedArray.recycle()

       // val textLayoutParams = LayoutParams(0, LayoutParams.WRAP_CONTENT, textWeight)
        val ratingBarLayout = LayoutInflater.from(context).inflate(R.layout.rating_bar_layout, this, false) as LinearLayout

       orientation =  VERTICAL
        addView(ratingBarLayout)

        rating_1.setOnClickListener {
            rating=1
            animateVectorDrawable(R.drawable.empty_to_full, rating_1)

            rating_2.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            rating_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            rating_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            rating_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))

        }
        rating_2.setOnClickListener {
            rating=2
            animateVectorDrawable(R.drawable.empty_to_full, rating_1)
            animateVectorDrawable(R.drawable.empty_to_full, rating_2)

            rating_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            rating_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            rating_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))

        }
        rating_3.setOnClickListener {
            rating=3
            animateVectorDrawable(R.drawable.empty_to_full, rating_1)
            animateVectorDrawable(R.drawable.empty_to_full, rating_2)
            animateVectorDrawable(R.drawable.empty_to_full, rating_3)

            rating_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            rating_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))

        }
        rating_4.setOnClickListener {
            rating=4
            animateVectorDrawable(R.drawable.empty_to_full, rating_1)
            animateVectorDrawable(R.drawable.empty_to_full, rating_2)
            animateVectorDrawable(R.drawable.empty_to_full, rating_3)
            animateVectorDrawable(R.drawable.empty_to_full, rating_4)

            rating_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))

        }
        rating_5.setOnClickListener {
            rating=5
            animateVectorDrawable(R.drawable.empty_to_full, rating_1)
            animateVectorDrawable(R.drawable.empty_to_full, rating_2)
            animateVectorDrawable(R.drawable.empty_to_full, rating_3)
            animateVectorDrawable(R.drawable.empty_to_full, rating_4)
            animateVectorDrawable(R.drawable.empty_to_full, rating_5)
        }

    }
    private fun animateVectorDrawable(id: Int, view: ImageView) {
        val animatedVectorDrawable = ContextCompat.getDrawable(context, id)
        view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()
    }





}