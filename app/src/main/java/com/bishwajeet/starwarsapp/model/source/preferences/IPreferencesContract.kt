package com.bishwajeet.starwarsapp.model.source.preferences

interface IPreferencesContract {

    fun saveTheme(theme: String)

    fun getTheme(): String?
}