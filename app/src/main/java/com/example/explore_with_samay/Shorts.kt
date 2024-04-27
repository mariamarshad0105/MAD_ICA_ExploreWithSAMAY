package com.example.explore_with_samay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

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
        val videosLayout: LinearLayout = view.findViewById(R.id.videosLayout)

        // List of video URLs
        val videoUrls = listOf(
            "https://www.youtube.com/embed/ZOIhcNiYRaU",
            "https://www.youtube.com/embed/8luUsnB5ong",
            "https://www.youtube.com/embed/7oX93fMVFwk"
            // Add more video URLs here
        )

        // Create a WebView for each video and add it to the layout
        videoUrls.forEach { videoUrl ->
            val webView = WebView(context ?: return null)
            val layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                resources.getDimensionPixelSize(R.dimen.video_height)
            )
            webView.layoutParams = layoutParams
            val videoHtml = "<iframe width=\"100%\" height=\"100%\" src=\"$videoUrl\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
            webView.loadData(videoHtml, "text/html", "utf-8")
            webView.settings.javaScriptEnabled = true
            webView.settings.mediaPlaybackRequiresUserGesture = false
            webView.settings.loadWithOverviewMode = true
            webView.settings.useWideViewPort = true
            webView.webChromeClient = WebChromeClient()

            videosLayout.addView(webView)
        }

        return view
    }
}
