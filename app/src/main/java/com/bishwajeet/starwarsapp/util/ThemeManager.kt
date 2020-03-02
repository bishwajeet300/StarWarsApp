package com.bishwajeet.starwarsapp.util

import androidx.appcompat.app.AppCompatDelegate

object ThemeManager {

    private const val LIGHT_MODE = "Force"
    private const val DARK_MODE = "Dark Side"
    private const val FOLLOW_SYSTEM_MODE = "Device Theme"

    fun applyTheme(themePreference: String?) {
        when (themePreference) {
            LIGHT_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            DARK_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            FOLLOW_SYSTEM_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }
}