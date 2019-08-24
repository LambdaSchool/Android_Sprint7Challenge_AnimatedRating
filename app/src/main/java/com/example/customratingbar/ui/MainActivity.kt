package com.example.customratingbar.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.customratingbar.R
import com.example.customratingbar.views.RatingBarView
import com.example.customratingbar.fragments.RatingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add_rating.setOnClickListener {
            val ratingFragment:DialogFragment = RatingFragment()
             ratingFragment.show(supportFragmentManager, "Rating Fragment")

        }
    }
    fun addView(){
        var textView= TextView(this)
        textView.text="${RatingBarView.name} ${RatingBarView.rating}"
        textView.textSize=20f
        layout_ratings.addView(textView)

    }

}
