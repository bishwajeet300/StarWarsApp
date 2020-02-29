package com.bishwajeet.starwarsapp.view.fragmentStarship

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.model.repository.StarshipRepository
import javax.inject.Inject

class StarshipDetailViewModel @Inject constructor(
    private val starshipRepository: StarshipRepository
): ViewModel() {

    private lateinit var id: String

    init {
        Log.i("StarshipDetailViewModel", "StarshipDetailViewModel created")
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("StarshipDetailViewModel", "StarshipDetailViewModel cleared")
    }
}