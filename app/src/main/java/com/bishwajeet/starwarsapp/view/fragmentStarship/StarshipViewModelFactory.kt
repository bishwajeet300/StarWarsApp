package com.bishwajeet.starwarsapp.view.fragmentStarship

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class StarshipViewModelFactory: ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StarshipViewModel::class.java)) {
            return StarshipViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}