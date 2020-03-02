package com.bishwajeet.starwarsapp

import android.app.Application
import com.bishwajeet.starwarsapp.di.ApplicationComponent
import com.bishwajeet.starwarsapp.di.DaggerApplicationComponent
import com.bishwajeet.starwarsapp.model.source.preferences.IPreferencesContract
import com.bishwajeet.starwarsapp.model.source.preferences.PreferencesDataSource
import com.bishwajeet.starwarsapp.util.ThemeManager
import javax.inject.Inject


class StarWarsApp: Application() {


    val applicationComponent: ApplicationComponent by lazy {
        initializeComponent()
    }


    fun initializeComponent(): ApplicationComponent {
        // Creates an instance of ApplicationComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}