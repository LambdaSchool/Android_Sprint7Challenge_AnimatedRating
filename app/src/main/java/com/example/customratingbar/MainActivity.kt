package com.example.customratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_rating.*

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
