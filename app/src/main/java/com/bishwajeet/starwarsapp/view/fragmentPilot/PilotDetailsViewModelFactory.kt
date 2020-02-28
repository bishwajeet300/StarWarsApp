package com.bishwajeet.starwarsapp.view.fragmentPilot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class PilotDetailsViewModelFactory(private val id: Int) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PilotDetailsViewModel::class.java)) {
            return PilotDetailsViewModel(id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}