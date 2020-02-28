package com.bishwajeet.starwarsapp.view.fragmentPilot

import android.util.Log
import androidx.lifecycle.ViewModel

class PilotViewModel: ViewModel() {
    init {
        Log.i("PilotViewModel", "PilotViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("PilotViewModel", "PilotViewModel cleared")
    }
}