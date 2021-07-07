package com.example.rating1

import android.content.ContentUris
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.core.content.ContextCompat
import org.w3c.dom.Attr


private const val MAX_RATING = 5

//assign default null values (in case values are not picked)
// (the reason context dont got a default is because its constantly being used in code below)
//trying to create an initial costum view that uses linear layout with those required constructors
class CustomView : LinearLayout{

    constructor(context: Context): super(context)
    constructor(context: Context, attributeSet: AttributeSet?): super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
            :super(context, attributeSet, defStyleAttr, defStyleRes)



    //here is how to generate random strings
    val list = mutableListOf("dog","cat","horse","pig","i dunno","dog","cat","horse","pig","i dunno")
    // we need a pointer
    var pointer = 0
    fun incPointer(){
        pointer++
        if(pointer >= list.size){
            pointer = 0

        }
    }
    fun decPointer(){
        pointer--
        if (pointer < 0){
            pointer = list.size -1
        }
    }
    // then we always add init block for constructors
    init{
        // you can attach those constructor to the item and inflate it in the current layout
     val textView = LayoutInflater.from(context).inflate(R.layout.comboview_layout, this, false) as TextView
    //construct a few image views
        val previousImageView = ImageView(context)
        val nextImageView = ImageView(context)
        orientation = HORIZONTAL
        //always add views in order


        addView(textView)
        textView.text = list[pointer]

        // for image view we will use a resource
        addView(previousImageView)
        previousImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.blk_star))
        // now add listener to image view
        previousImageView.setOnClickListener {
            decPointer()
            textView.text = list[pointer]
        }


        addView(nextImageView)
        nextImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.emp_star))

        nextImageView.setOnClickListener {
            incPointer()
            textView.text = list[pointer]
        }

    }
}

