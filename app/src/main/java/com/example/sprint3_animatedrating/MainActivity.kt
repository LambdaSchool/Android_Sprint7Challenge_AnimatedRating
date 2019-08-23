package com.example.sprint3_animatedrating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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




    }


}
