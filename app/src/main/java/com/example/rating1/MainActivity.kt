package com.example.rating1

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.rating1.lists.RatingList
import kotlinx.android.synthetic.main.activity_main.animation_view
import kotlinx.android.synthetic.main.activity_main.btnSubmit
import kotlinx.android.synthetic.main.activity_main.etFeedBack
import kotlinx.android.synthetic.main.activity_main.list_layout
import kotlinx.android.synthetic.main.activity_main.ratingBar
import kotlinx.android.synthetic.main.activity_main.tvRatingScale
import kotlinx.android.synthetic.main.fragment_first.*


class MainActivity : AppCompatActivity() {
    companion object {

        val EXTRA_STRING: String? = "data"

        val RESULT_INT: Int = 54321

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val rating :RatingList= intent.getSerializableExtra(MainActivity.EXTRA_STRING) as RatingList


        //null exception
        if (rating.name!=getString(R.string.app_name)) {

            etFeedBack.setText(rating.name)

            ratingBar.numStars = rating.rating

        }



        btnSubmit.setOnClickListener {

            val intent = Intent()

            intent.putExtra(MainActivity.EXTRA_STRING, RatingList(etFeedBack.text.toString(), rating = 1))

            setResult(Activity.RESULT_OK, intent)

            finish()

        }





        //    AnimateVectorFun()
        btnSubmit.setOnClickListener {

            val intent = Intent()

            intent.putExtra(MainActivity.EXTRA_STRING, RatingList( etFeedBack.toString(), ratingBar.numStars))

            setResult(Activity.RESULT_OK, intent)

            finish()

        }





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

        animation_view.setOnClickListener {
            AnimateVectorFun(R.drawable.avd_cust, it as ImageView)
        }

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

    private fun AnimateVectorFun(id: Int, view: ImageView) {
        val animatedVectorDrawable = ContextCompat.getDrawable(this, id)
        view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()


    }
    override fun onBackPressed() {

        val intent = Intent()

        intent.putExtra(MainActivity.EXTRA_STRING, RatingList(getString(R.string.app_name)))

        setResult(Activity.RESULT_CANCELED, intent)

        finish()

    }

}
