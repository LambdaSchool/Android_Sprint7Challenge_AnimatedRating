package com.example.customratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add_rating.setOnClickListener {
            val ratingFragment:DialogFragment = RatingFragment()
            ratingFragment.show(supportFragmentManager, "Rating Fragment")
            var textView= TextView(this)
            textView.text="test"
            layout_ratings.addView(textView)


        }
    }

}
