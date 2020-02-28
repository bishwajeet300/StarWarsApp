package com.bishwajeet.starwarsapp.view.fragmentStarship

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class StarshipDetailViewModelFactory(private val id: String) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StarshipDetailViewModel::class.java)) {
            return StarshipDetailViewModel(id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}