package com.app.grammarapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class SplashScreenActivity : AppCompatActivity() {

    var getStarted: AppCompatButton ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        getStarted = findViewById(R.id.getStarted)

        getStarted!!.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(
            ViewPumpContextWrapper.wrap(newBase!!))
    }
}