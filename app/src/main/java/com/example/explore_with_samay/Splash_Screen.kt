package com.example.explore_with_samay

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Splash_Screen : AppCompatActivity() {

    private val SPLASH_DURATION: Long = 4000 // 3 seconds
    private val ROTATION_DURATION: Long = 2000 // 2 seconds
    private val ZOOM_DURATION: Long = 2000 // 1 second

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val imageView: ImageView = findViewById(R.id.imageView)

        // Animation: Rotate Animation
        val rotateAnimation = RotateAnimation(
            0f, 360f, // Start and end rotation degrees
            Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point X (center)
            Animation.RELATIVE_TO_SELF, 0.5f // Pivot point Y (center)
        )
        rotateAnimation.duration = ROTATION_DURATION
        rotateAnimation.fillAfter = true // Keeps the final rotation state

        // Animation: Zoom In Animation
        val zoomInAnimation = ScaleAnimation(
            1f, 1.5f, // Start and end scale on X-axis
            1f, 1.5f, // Start and end scale on Y-axis
            Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point X (center)
            Animation.RELATIVE_TO_SELF, 0.5f // Pivot point Y (center)
        )
        zoomInAnimation.duration = ZOOM_DURATION
        zoomInAnimation.startOffset = ROTATION_DURATION // Wait until rotation completes

        // Animation Set for sequential animations
        val animationSet = AnimationSet(false) // false for sequential execution
        animationSet.addAnimation(rotateAnimation)
        animationSet.addAnimation(zoomInAnimation)

        // Set animation listener
        animationSet.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                // Navigate to MainActivity after animation completes
                startActivity(Intent(this@Splash_Screen, MainActivity::class.java))
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        // Start animation on ImageView
        imageView.startAnimation(animationSet)

        // Delayed navigation after animation duration
        Handler().postDelayed({
            startActivity(Intent(this@Splash_Screen, MainActivity::class.java))
            finish()
        }, SPLASH_DURATION)
    }
}
