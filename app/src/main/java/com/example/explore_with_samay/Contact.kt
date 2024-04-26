package com.example.explore_with_samay

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.explore_with_samay.R

class Contact : Fragment() {

    companion object {
        fun newInstance(): Contact {
            return Contact()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        // Find the ImageViews
        val youtubeImageView: ImageView = view.findViewById(R.id.socialImageView)
        val tiktokImageView: ImageView = view.findViewById(R.id.socialImageView1)
        val instagramImageView: ImageView = view.findViewById(R.id.socialImageView2)
        val whatsappImageView: ImageView = view.findViewById(R.id.socialImageView3)
        val gmailImageView: ImageView = view.findViewById(R.id.socialImageView4)
        val facebookImageView: ImageView = view.findViewById(R.id.socialImageView5)
        val twitterImageView: ImageView = view.findViewById(R.id.socialImageView6)

        // Set onClickListeners for each ImageView
        youtubeImageView.setOnClickListener {
            openSocialMediaPage("https://www.youtube.com/@explorewithsamaygoodfood9663/featured")
        }
        tiktokImageView.setOnClickListener {
            openSocialMediaPage("https://www.tiktok.com/@xplore_with_samay?is_from_webapp=1&sender_device=pc")
        }
        instagramImageView.setOnClickListener {
            openSocialMediaPage("https://www.instagram.com/samay_goodfood/")
        }
        whatsappImageView.setOnClickListener {
            openSocialMediaPage("https://wa.me/447419750400")
            // Replace "your_whatsapp_number" with your actual WhatsApp number
        }
        gmailImageView.setOnClickListener {
            openSocialMediaPage("mailto:mariamarshad0105@gmail.com")
            // Replace "your_email@gmail.com" with your actual Gmail address
        }
        facebookImageView.setOnClickListener {
            openSocialMediaPage("https://www.facebook.com/Cooking.with.SAMAY")
        }
        twitterImageView.setOnClickListener {
            openSocialMediaPage("https://twitter.com/SamayCooking")
        }

        return view
    }

    private fun openSocialMediaPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}
