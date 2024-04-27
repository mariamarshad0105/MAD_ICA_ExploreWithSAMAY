package com.example.explore_with_samay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.PagerSnapHelper


class Shorts : Fragment() {

    companion object {
        fun newInstance(): Shorts {
            return Shorts()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_shorts, container, false)

        // Container for WebViews
        val videosLayout: RecyclerView = view.findViewById(R.id.videosRecyclerView)

        // List of video URLs
        val videoUrls = listOf(
            "https://www.youtube.com/embed/FP6OXJ62hQI",
            "https://www.youtube.com/embed/8luUsnB5ong",
            "https://www.youtube.com/embed/phYVSgdSGFw",
            "https://www.youtube.com/embed/ZOIhcNiYRaU",
            "https://www.youtube.com/embed/8A-DmtUvAN0",
            "https://www.youtube.com/embed/7oX93fMVFwk"
            // Add more video URLs here
        )

        // Create a WebView for each video and add it to the layout
        videosLayout.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ShortsAdapter(videoUrls.map { VideoModel(it) })
            // Attach PagerSnapHelper
            val pagerSnapHelper = PagerSnapHelper()
            pagerSnapHelper.attachToRecyclerView(this)
        }

        return view
    }

}

