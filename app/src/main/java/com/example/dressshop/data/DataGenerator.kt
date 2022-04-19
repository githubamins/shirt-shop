package com.example.dressshop.data

import com.example.dressshop.R
import com.example.dressshop.model.ModelMan
import com.example.dressshop.model.Shirt

class DataGenerator {
    private var picturesArray = arrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3
    )
    private var shirtArray = arrayOf(
        R.drawable.sample_t_shirt,
        R.drawable.sample_tshirt2,
        R.drawable.sample_tshirt3,
        R.drawable.sample_tshirt4
    )
    private var nameShirtArray = arrayOf(
        "green shirt",
        "black art shirt",
        "galaxy shirt",
        "white pink shirt"
    )
    private var costShirtArray = arrayOf(
        "$60.50",
        "$98.00",
        "$70.55",
        "$87.00"
    )

    fun generateDataViewPage(): List<ModelMan> {
        val items = ArrayList<ModelMan>()
        for (i in picturesArray) {
            val modelMan = ModelMan()
            modelMan.image = i
            items.add(modelMan)
        }
        return items
    }

    fun generateDataViewPage2(): List<Shirt> {
        val items = ArrayList<Shirt>()
        for (i in shirtArray.indices) {
            val shirt = Shirt()
            shirt.id = i + 1
            shirt.name = nameShirtArray[i]
            shirt.price = costShirtArray[i]
            shirt.image = shirtArray[i]
            items.add(shirt)
        }
        return items

    }
}