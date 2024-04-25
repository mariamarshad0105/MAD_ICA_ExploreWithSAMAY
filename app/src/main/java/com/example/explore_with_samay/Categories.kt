package com.example.explore_with_samay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Categories : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter

    companion object {
        fun newInstance(): Categories {
            return Categories()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = CategoryAdapter(getCategoryList())
        recyclerView.adapter = adapter
        return view
    }

    private fun getCategoryList(): List<Category> {
        // Create a list of category items (Category objects with image and name)
        val categories = mutableListOf<Category>()
        categories.add(Category("Desserts", R.drawable.food_bp_smoothie))
        categories.add(Category("Bakery", R.drawable.food_patties))
        categories.add(Category("Drinks", R.drawable.food_soflay))
        categories.add(Category("Salads", R.drawable.food_choc_trifle))
        categories.add(Category("Pasta", R.drawable.food_patties))
        categories.add(Category("Breakfast", R.drawable.food_choc_trifle))
        categories.add(Category("Appetizers", R.drawable.food_choc_trifle))
        categories.add(Category("Mains", R.drawable.food_choc_trifle))
        categories.add(Category("Ice Creams", R.drawable.food_choc_trifle))
        // Add more categories as needed
        return categories
    }
}



