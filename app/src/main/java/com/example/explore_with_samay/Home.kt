package com.example.explore_with_samay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
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
            R.drawable.food_soflay
        )

        val screenWidth = resources.displayMetrics.widthPixels
        val margin = resources.getDimensionPixelSize(R.dimen.image_margin)
        val columnCount = 2

        // Calculate total available width for the grid
        val totalPadding = (columnCount + 1) * margin
        val availableWidth = screenWidth - totalPadding
        val imageWidth = availableWidth / columnCount

        imageGridLayout.columnCount = columnCount

        for (resId in imageResources) {
            val imageView = ImageView(requireContext())
            imageView.setImageResource(resId)
            imageView.adjustViewBounds = true
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP // Ensure the image fills the space

            val layoutParams = GridLayout.LayoutParams().apply {
                width = imageWidth
                height = ViewGroup.LayoutParams.WRAP_CONTENT // Wrap content for height
                setMargins(margin, margin, margin, margin)
            }

            imageGridLayout.addView(imageView, layoutParams)
        }
    }

}
