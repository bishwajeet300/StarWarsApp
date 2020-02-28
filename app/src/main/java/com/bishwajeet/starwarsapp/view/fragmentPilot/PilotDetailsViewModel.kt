package com.bishwajeet.starwarsapp.view.fragmentPilot

import android.util.Log
import androidx.lifecycle.ViewModel

class PilotDetailsViewModel(pilot_id: Int): ViewModel() {

    var id = pilot_id

    init {
        Log.i("PilotDetailsViewModel", "PilotDetailsViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("PilotDetailsViewModel", "PilotDetailsViewModel cleared")
    }
}