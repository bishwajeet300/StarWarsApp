package com.bishwajeet.starwarsapp.model.source.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesDataSource @Inject constructor(context: Context) : IPreferencesContract {

    val preferences: SharedPreferences = context.getSharedPreferences("StarWarsPreferences", Context.MODE_PRIVATE)


    override fun saveTheme(theme: String) {

        preferences.edit().putString("THEME", theme).apply()
    }


    override fun getTheme(): String? {
        return preferences.getString("THEME", "System")// default to device theme
    }
}