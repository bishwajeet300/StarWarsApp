package com.bishwajeet.starwarsapp.view.fragmentStarship

import android.util.Log
import androidx.lifecycle.ViewModel

class StarshipDetailViewModel(starship_id: String): ViewModel() {

    var id = starship_id

    init {
        Log.i("StarshipDetailViewModel", "StarshipDetailViewModel created")
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("StarshipDetailViewModel", "StarshipDetailViewModel cleared")
    }
}