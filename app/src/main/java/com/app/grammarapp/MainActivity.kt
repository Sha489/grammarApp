package com.app.grammarapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.app.grammarapp.english.EnglishImprovisationActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class MainActivity : AppCompatActivity() {

    var cardView: CardView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardView = findViewById(R.id.cardView)

        cardView!!.setOnClickListener {
            startActivity(Intent(applicationContext, EnglishImprovisationActivity::class.java))
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(
            ViewPumpContextWrapper.wrap(newBase!!))
    }
}