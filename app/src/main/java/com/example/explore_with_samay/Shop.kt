package com.example.explore_with_samay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Shop : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CategoryAdapter

    companion object {
        fun newInstance(): Shop {
            return Shop()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shop, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = CategoryAdapter(getCategoryList())
        recyclerView.adapter = adapter
        return view
    }

    private fun getCategoryList(): List<Category> {
        // Create a list of category items (Category objects with image and name)
        val categories = mutableListOf<Category>()
        categories.add(Category("Desserts", R.drawable.cat_desserts))
        categories.add(Category("Bakery", R.drawable.cat_bakery))
        categories.add(Category("Drinks", R.drawable.cat_drinks))
        categories.add(Category("Salads", R.drawable.cat_salad))
        categories.add(Category("Pasta", R.drawable.cat_pasta))
        categories.add(Category("Breakfast", R.drawable.cat_breakfast))
        categories.add(Category("Appetizers", R.drawable.cat_appetizers))
        categories.add(Category("Mains", R.drawable.cat_mains))
        categories.add(Category("Ice Creams", R.drawable.cat_icecreams))
        // Add more categories as needed
        return categories
    }
}



