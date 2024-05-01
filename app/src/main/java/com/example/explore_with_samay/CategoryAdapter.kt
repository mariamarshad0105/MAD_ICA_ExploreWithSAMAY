package com.example.explore_with_samay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// Define the data class to represent a category item
data class Category(val name: String, val imageResId: Int)


// Define the adapter for the RecyclerView
class CategoryAdapter(private val categoryList: List<Category>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        // Inflate the item layout
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_shop, parent, false)
        // Return ViewHolder instance
        return CategoryViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.categoryTextView.text = category.name
        holder.imageView.setImageResource(category.imageResId)
    }


    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val imageView: ImageView = itemView.findViewById(R.id.categoryImageView)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
            return
        }
    }
}

