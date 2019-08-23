package com.example.rating1

import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

import android.widget.Toast

import android.view.View
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AnimateVectorFun()





        ratingBar.setOnRatingBarChangeListener(RatingBar.OnRatingBarChangeListener { ratingBar, v, b ->
            tvRatingScale.setText(v.toString())
            when (ratingBar.rating.toInt()) {
                1 -> tvRatingScale.setText("Very bad")

                2 -> tvRatingScale.setText("Need some improvement")
                3 -> tvRatingScale.setText("Good")
                4 -> tvRatingScale.setText("Great")
                5 -> tvRatingScale.setText("Awesome. I love it")
                else -> tvRatingScale.setText("")
            }
        })

        btnSubmit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (tvRatingScale.getText().toString().isEmpty()) {
                    Toast.makeText(this@MainActivity, "Please fill in feedback text box", Toast.LENGTH_LONG).show()
                } else {
                    tvRatingScale.setText("")
                    ratingBar.setRating(0f)
                    Toast.makeText(this@MainActivity, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show()
                }
            }
        })




    }

    private fun AnimateVectorFun() {
        val animatedVectorDrawable = ContextCompat.getDrawable(this, R.drawable.avd_cust)
        animation_view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()
    }

}
