package com.bishwajeet.starwarsapp.view.fragmentPilot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class PilotViewModelFactory: ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PilotViewModel::class.java)) {
            return PilotViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}