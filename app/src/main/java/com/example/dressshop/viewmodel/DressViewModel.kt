package com.example.dressshop.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dressshop.data.DataGenerator
import com.example.dressshop.model.ModelMan
import com.example.dressshop.model.Shirt
import kotlin.math.abs

class DressViewModel: ViewModel() {

    private lateinit var _pictureViewPage: List<ModelMan>
    val pictureViewModel: List<ModelMan> get() = _pictureViewPage

    private lateinit var _shirtData: List<Shirt>
    val shirtData: List<Shirt> get() = _shirtData

    private val nextItemVisiblePx = 100
    private val currentItemHorizontalMarginPx = 150
    private val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
    private val dataGenerator= DataGenerator()


    init {
        dataFromDate()
        getDataShirt()
    }
    private fun dataFromDate(){
        _pictureViewPage = dataGenerator.generateDataViewPage()
    }

    private fun getDataShirt(){
        _shirtData = dataGenerator.generateDataViewPage2()
    }


    fun calculateTranslationX(position: Float):Float{
        return -pageTranslationX * position
    }

    fun calculateScaleXAndY(position: Float):Float{
        return (1-(0.95f * abs(position)))
    }
}