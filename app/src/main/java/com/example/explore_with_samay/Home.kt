package com.example.explore_with_samay

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class Home : Fragment() {

    private lateinit var imageGridLayout: GridLayout

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
                setMargins(margin, margin, margin, margin + 10)
            }
            imageView.layoutParams = layoutParams

            // Set OnClickListener for each ImageView
            imageView.setOnClickListener {
                // Start RecipeDetailActivity and pass image ID as extra
                val intent = Intent(requireContext(), RecipeDetailActivity::class.java).apply {
                    putExtra("image_id", resId)
                }
                startActivity(intent)
            }

            imageGridLayout.addView(imageView)
        }
    }
}
