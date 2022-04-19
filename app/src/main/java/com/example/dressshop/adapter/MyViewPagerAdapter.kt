package com.example.dressshop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dressshop.databinding.ListItemViewPageBinding
import com.example.dressshop.model.ModelMan

class MyViewPagerAdapter(private val items:List<ModelMan>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemHolder(binding: ListItemViewPageBinding): RecyclerView.ViewHolder(binding.root){
        private val imageView: ImageView = binding.imageViewPager
        fun bind(modelMan: ModelMan){
            imageView.load(modelMan.image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = ListItemViewPageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemHolder){
            val vh : ItemHolder = holder
            vh.bind(items[position])
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

}