package com.example.explore_with_samay

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class OrderFood : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_order_food, container, false)

        // Find the ImageView for WhatsApp
        val whatsappImageView: ImageView = view.findViewById(R.id.imageView1)

        whatsappImageView.setOnClickListener {
            openSocialMediaPage("https://wa.me/447419750400")
        }

        return view
    }

    private fun openSocialMediaPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}

