package com.example.explore_with_samay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.recyclerview.widget.RecyclerView
import android.webkit.WebViewClient


data class VideoModel(val url: String)

class ShortsAdapter(private val videoList: List<VideoModel>) : RecyclerView.Adapter<ShortsAdapter.ShortsViewHolder>() {

    class ShortsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoWebView: WebView = itemView.findViewById(R.id.videoWebView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return ShortsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShortsViewHolder, position: Int) {
        val videoUrl = videoList[position].url
        holder.videoWebView.apply {
            settings.javaScriptEnabled = true
            settings.mediaPlaybackRequiresUserGesture = false
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            webChromeClient = WebChromeClient()
            webViewClient = object : WebViewClient() { // Make sure to specify WebViewClient
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    // Inject JavaScript to play the video and loop it
                    evaluateJavascript(
                        """
                    (function() {
                        var video = document.getElementsByTagName('video')[0];
                        video.addEventListener('ended', function() {
                            video.play();
                        });
                        video.play();
                    })();
                    """.trimIndent(),
                        null
                    )
                }
            }
            loadDataWithBaseURL(null, videoHtml(videoUrl), "text/html", "utf-8", null)
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    private fun videoHtml(videoUrl: String): String {
        val modifiedUrl = "$videoUrl?rel=0&modestbranding=1"
        return "<iframe width=\"100%\" height=\"100%\" src=\"$modifiedUrl\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"
    }




}