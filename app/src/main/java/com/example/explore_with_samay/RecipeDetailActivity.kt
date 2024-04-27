package com.example.explore_with_samay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class RecipeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.videoView)
        lifecycle.addObserver(youTubePlayerView)
    }

}
