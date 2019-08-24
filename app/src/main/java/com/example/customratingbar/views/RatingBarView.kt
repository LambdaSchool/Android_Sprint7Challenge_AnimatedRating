package com.example.customratingbar.views

import android.content.Context
import android.graphics.drawable.Animatable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.customratingbar.R
import kotlinx.android.synthetic.main.rating_bar_layout.view.*

class RatingBarView (context: Context, attrs: AttributeSet?): LinearLayout(context, attrs) {

    constructor(context: Context): this(context, null)

companion object {
    var rating: Int = 1
    var name: String = ""
}

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatingBarView)
        val maxRatings = typedArray.getInteger(R.styleable.RatingBarView_maximum_ratings,5)
        val startingRating = typedArray.getInteger(R.styleable.RatingBarView_starting_rating,1)
        typedArray.recycle()

        val ratingBarLayout = LayoutInflater.from(context).inflate(R.layout.rating_bar_layout, this, false) as LinearLayout
        addView(ratingBarLayout)
        addRatingSymbols(maxRatings)
        rating =startingRating
        for(i in 1..rating_star_layout.getChildAt(rating -1).id) {
            var startingSymbol = rating_star_layout.getChildAt(i - 1) as ImageView
            startingSymbol.setImageDrawable(ContextCompat.getDrawable(context,
                R.drawable.full_to_empty
            ))
        }
        orientation =  VERTICAL

    }
    private fun animateVectorDrawable(id: Int, view: ImageView) {
        val animatedVectorDrawable = ContextCompat.getDrawable(context, id)
        view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()
    }
    private fun addRatingSymbols(count:Int){
        val imageLayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        for(i in 1..count){
        val ratingStarImage= ImageView(context)
            ratingStarImage.layoutParams = imageLayoutParams
            ratingStarImage.setImageDrawable(ContextCompat.getDrawable(context,
                R.drawable.empty_star
            ))
            ratingStarImage.id=i
            ratingStarImage.setOnClickListener {
                for(i in 1..it.id)
                {
                    animateVectorDrawable(R.drawable.empty_to_full,rating_star_layout.getChildAt(i-1) as ImageView)
                }
                for(i in it.id+1..rating)
                {
                    animateVectorDrawable(R.drawable.full_to_empty,rating_star_layout.getChildAt(i-1) as ImageView)
                }
                rating =ratingStarImage.id
                name =editText_name.text.toString() }

                rating_star_layout.addView(ratingStarImage)
        }


    }

}


