package com.example.explore_with_samay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Using Handler to delay navigation
        Handler().postDelayed({
            // Start MainActivity after delay
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Close this activity
        }, 3000) // Delay in milliseconds (e.g., 3000ms = 3 seconds)
    }
}