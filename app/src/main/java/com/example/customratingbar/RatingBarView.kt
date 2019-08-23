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

companion object {
    var rating: Int = 1
    var name: String = ""
}

    init {

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
            name=editText_name.text.toString()
        }
        rating_2.setOnClickListener {
            rating=2
            animateVectorDrawable(R.drawable.empty_to_full, rating_1)
            animateVectorDrawable(R.drawable.empty_to_full, rating_2)

            rating_3.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            rating_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            rating_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            name=editText_name.text.toString()

        }
        rating_3.setOnClickListener {
            rating=3
            animateVectorDrawable(R.drawable.empty_to_full, rating_1)
            animateVectorDrawable(R.drawable.empty_to_full, rating_2)
            animateVectorDrawable(R.drawable.empty_to_full, rating_3)

            rating_4.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            rating_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            name=editText_name.text.toString()

        }
        rating_4.setOnClickListener {
            rating=4
            animateVectorDrawable(R.drawable.empty_to_full, rating_1)
            animateVectorDrawable(R.drawable.empty_to_full, rating_2)
            animateVectorDrawable(R.drawable.empty_to_full, rating_3)
            animateVectorDrawable(R.drawable.empty_to_full, rating_4)

            rating_5.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.empty_star))
            name=editText_name.text.toString()

        }
        rating_5.setOnClickListener {
            rating=5
            animateVectorDrawable(R.drawable.empty_to_full, rating_1)
            animateVectorDrawable(R.drawable.empty_to_full, rating_2)
            animateVectorDrawable(R.drawable.empty_to_full, rating_3)
            animateVectorDrawable(R.drawable.empty_to_full, rating_4)
            animateVectorDrawable(R.drawable.empty_to_full, rating_5)
            name=editText_name.text.toString()
        }

    }
    private fun animateVectorDrawable(id: Int, view: ImageView) {
        val animatedVectorDrawable = ContextCompat.getDrawable(context, id)
        view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()
    }

}