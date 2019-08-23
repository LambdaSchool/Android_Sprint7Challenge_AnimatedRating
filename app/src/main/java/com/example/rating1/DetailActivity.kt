package com.example.rating1

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.rating1.FragmentActivity.Companion.EXTRA_STRING
import com.example.rating1.FragmentActivity.Companion.RESULT_INT
import com.example.rating1.lists.RatingList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.list_layout
import kotlinx.android.synthetic.main.fragment_first.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val rating: RatingList = intent.getSerializableExtra(MainActivity.EXTRA_STRING) as RatingList


        //null exception
        if (rating.name != getString(R.string.app_name)) {

            sample_text1.setText(rating.name)


        }



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

