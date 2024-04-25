package com.example.explore_with_samay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat

class Favourites : Fragment() {

    private lateinit var imageGridLayout: GridLayout

    companion object {
        fun newInstance(): Favourites {
            return Favourites()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favourites, container, false)
        imageGridLayout = view.findViewById(R.id.imageGridLayout)
        setupImages() // Load and display images
        return view
    }

    private fun setupImages() {
        val imageResources = arrayOf(
            R.drawable.food_bp_smoothie,
            R.drawable.food_cheese_cake,
            R.drawable.food_choc_trifle,
            R.drawable.food_patties,
            R.drawable.food_soflay,
            R.drawable.food_choc_trifle,
            R.drawable.food_cheese_cake,
            R.drawable.food_soflay,
            R.drawable.food_bp_smoothie,
            R.drawable.food_cheese_cake,
            R.drawable.food_choc_trifle,
            R.drawable.food_patties,
            R.drawable.food_soflay,
            R.drawable.food_choc_trifle,
            R.drawable.food_cheese_cake,
            R.drawable.food_soflay,
            R.drawable.food_patties
        )

        val margin = resources.getDimensionPixelSize(R.dimen.image_margin)
        val screenWidth = resources.displayMetrics.widthPixels
        val spacing = 2 * margin // Double the margin for both sides of each image
        val imageWidth = (screenWidth - spacing) / 2 // Calculate total width for each image

        for (resId in imageResources) {
            val imageView = ImageView(requireContext())
            imageView.setImageResource(resId)
            imageView.adjustViewBounds = true
            imageView.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_corner)
            imageView.clipToOutline = true
            val layoutParams = GridLayout.LayoutParams().apply {
                width = imageWidth - 30
                height = GridLayout.LayoutParams.WRAP_CONTENT
                setMargins(margin, margin, margin, margin+10)
            }
            imageView.layoutParams = layoutParams
            imageGridLayout.addView(imageView)
        }
    }

}
