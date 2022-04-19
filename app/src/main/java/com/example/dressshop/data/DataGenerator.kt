package com.example.dressshop.data

import com.example.dressshop.R
import com.example.dressshop.model.ModelMan

class DataGenerator {
    private var picturesArray = arrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3
    )
    fun generateDataViewPage():List<ModelMan>{
        val items = ArrayList<ModelMan>()
        for (i in picturesArray){
            val modelMan = ModelMan()
            modelMan.image = i
            items.add(modelMan)
        }
        return items
    }
}