package com.example.dressshop.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dressshop.data.DataGenerator
import com.example.dressshop.model.ModelMan
import kotlin.math.abs

class DressViewModel: ViewModel() {

    private lateinit var _pictureViewPage: List<ModelMan>
    val pictureViewModel: List<ModelMan> get() = _pictureViewPage

    private val nextItemVisiblePx = 100
    private val currentItemHorizontalMarginPx = 150
    private val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx


    init {
        dataFromDate()
    }
    private fun dataFromDate(){
        val dataGenerator= DataGenerator()
        _pictureViewPage = dataGenerator.generateDataViewPage()
    }

    fun calculateTranslationX(position: Float):Float{
        return -pageTranslationX * position
    }

    fun calculateScaleXAndY(position: Float):Float{
        return (1-(0.95f * abs(position)))
    }
}