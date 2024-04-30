package com.example.explore_with_samay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// Define the data class to represent a category item
data class Category(val title: String, val imageResId: Int)

// Define the adapter for the RecyclerView
class CategoryAdapter(private val categories: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    // ViewHolder to hold the views for each item
    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val imageView: ImageView = itemView.findViewById(R.id.categoryImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shop, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryTextView.text = category.title
        holder.imageView.setImageResource(category.imageResId)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}
