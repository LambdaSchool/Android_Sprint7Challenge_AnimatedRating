package com.example.rating1

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.rating1.lists.RatingList
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.animation_view
import kotlinx.android.synthetic.main.activity_main.btnSubmit
import kotlinx.android.synthetic.main.activity_main.etFeedBack
import kotlinx.android.synthetic.main.activity_main.list_layout
import kotlinx.android.synthetic.main.activity_main.ratingBar
import kotlinx.android.synthetic.main.activity_main.tvRatingScale
import kotlinx.android.synthetic.main.fragment_first.*

class FragmentActivity : AppCompatActivity() {
    companion object {

        val EXTRA_STRING: String? = "This is my Rating"

        val RESULT_INT: Int = 54321

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)






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
        btnSubmit.setOnClickListener {

            val intent = Intent()

            intent.putExtra(MainActivity.EXTRA_STRING, RatingList(sample_text_detail.text.toString()))

            setResult(Activity.RESULT_OK, intent)

            finish()

        }





        btnSubmit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (tvRatingScale.getText().toString().isEmpty()) {
                    textViewGenerator(name = RatingList())
                    Toast.makeText(this@FragmentActivity, "Please fill in feedback text box", Toast.LENGTH_LONG).show()
                } else {
                    tvRatingScale.setText("")
                    textViewGenerator(name = RatingList())
                    ratingBar.setRating(0f)
                    Toast.makeText(this@FragmentActivity, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show()
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
    private fun intentGenerator(name:  RatingList) {
        val intent = Intent(this,  DetailActivity::class.java)
        intent.putExtra(EXTRA_STRING, name)
        startActivityForResult(intent, RESULT_INT)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RESULT_INT && resultCode == Activity.RESULT_OK) {

            val name: RatingList = data?.getSerializableExtra(MainActivity.EXTRA_STRING) as RatingList
            val textView: TextView = textViewGenerator(name)
            list_layout.addView(textView)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    fun textViewGenerator(name: RatingList): TextView {
        val textView: TextView = TextView(this)
        textView.textSize = 30f
        textView.text = name.name



        textView.setOnClickListener {
            intentGenerator(name)
            list_layout.removeView(it)
        }
        return textView
    }

}

