package com.example.explore_with_samay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class Home : Fragment() {

    private lateinit var imageContainer: LinearLayout

    companion object {
        fun newInstance(): Home {
            return Home()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        imageContainer = view.findViewById(R.id.imageContainer)
        setupImages() // Load and display images
        return view
    }

    private fun setupImages() {
        val imageResources = arrayOf(
            R.drawable.food_bp_smoothie,
            R.drawable.food_cheese_cake,
            R.drawable.food_choc_trifle,
            R.drawable.food_patties,
            R.drawable.food_soflay
        )

        // Retrieve the margin value from resources
        val margin = resources.getDimensionPixelSize(R.dimen.image_margin)

        // Loop through image resources and add ImageViews to imageContainer
        for (resId in imageResources) {
            val imageView = ImageView(requireContext())
            imageView.setImageResource(resId)
            imageView.adjustViewBounds = true

            // Apply margin to the bottom of each ImageView
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.bottomMargin = margin // Set the bottom margin
            imageView.layoutParams = params

            imageContainer.addView(imageView)
        }
    }
}

