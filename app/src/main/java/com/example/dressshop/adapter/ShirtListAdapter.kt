package com.example.dressshop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dressshop.databinding.ListItemTshirtRecyclerBinding
import com.example.dressshop.model.Shirt
import java.util.*

class ShirtListAdapter(private val items: List<Shirt>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(binding: ListItemTshirtRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val image: ImageView = binding.imageViewAdapterShirt
        private val name: TextView = binding.textView1
        private val cost: TextView = binding.textView2
        fun bind(shirt: Shirt){
            image.load(shirt.image)
            name.text = shirt.name.uppercase(Locale.getDefault())
            cost.text = shirt.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(
            ListItemTshirtRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder){
            val vh: ItemViewHolder = holder
            vh.bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}