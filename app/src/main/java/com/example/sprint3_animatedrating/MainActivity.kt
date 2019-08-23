package com.example.sprint3_animatedrating

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.PopupWindow
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Showfrgm_popup()
    }

    fun Showfrgm_popup() {
        val transaction = manager.beginTransaction()
        val fragment = frgm_popup()
        transaction.replace(R.id.frag_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()


        btn_addRating.setOnClickListener{

            val inflater:LayoutInflater =getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.fragmentpopup,null)


            val popup = PopupWindow(
                view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
            )

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                popup.elevation = 10.0f
            }

            

        }




    }


}
