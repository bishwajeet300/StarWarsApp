package com.bishwajeet.starwarsapp.view.fragmentStarship

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.model.repository.StarshipRepository
import javax.inject.Inject

class StarshipViewModel @Inject constructor(
    private val starshipRepository: StarshipRepository
): ViewModel() {

    init {
        Log.i("StarshipViewModel", "StarshipViewModel created")
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("StarshipViewModel", "StarshipViewModel cleared")
    }
}