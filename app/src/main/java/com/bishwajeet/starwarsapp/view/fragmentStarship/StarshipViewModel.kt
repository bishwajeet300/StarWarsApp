package com.bishwajeet.starwarsapp.view.fragmentStarship

import android.util.Log
import androidx.lifecycle.ViewModel

class StarshipViewModel: ViewModel() {

    init {
        Log.i("StarshipViewModel", "StarshipViewModel created")
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("StarshipViewModel", "StarshipViewModel cleared")
    }
}