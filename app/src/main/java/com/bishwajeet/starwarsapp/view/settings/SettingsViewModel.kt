package com.bishwajeet.starwarsapp.view.settings

import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.model.source.preferences.IPreferencesContract
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject

class SettingsViewModel @Inject constructor(private val preferences: IPreferencesContract): ViewModel() {

    private val viewModelJob = SupervisorJob()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getCurrentTheme(): String? {
        return preferences.getTheme()
    }


    fun saveTheme(mode: String) {
        preferences.saveTheme(mode)
    }
}