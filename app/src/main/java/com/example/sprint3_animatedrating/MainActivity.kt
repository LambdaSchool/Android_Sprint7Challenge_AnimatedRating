package com.example.sprint3_animatedrating

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
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

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                val slideIn = Slide()
                slideIn.slideEdge = Gravity.TOP
                popup.enterTransition = slideIn

                val slideout = Slide()
                slideout.slideEdge = Gravity.RIGHT
                popup.exitTransition = slideout

            }

            val submit_btn = view.findViewById<Button>(R.id.submit_rating)

            submit_btn.setOnClickListener {
                popup.dismiss()
            }
            popup.setOnDismissListener {
                Toast.makeText(applicationContext,"Rating Submitted", Toast.LENGTH_SHORT).show()
            }

            TransitionManager.beginDelayedTransition(main_layout)
            popup.showAtLocation(
                main_layout, Gravity.CENTER, 0,0
            )

        }




    }


}
