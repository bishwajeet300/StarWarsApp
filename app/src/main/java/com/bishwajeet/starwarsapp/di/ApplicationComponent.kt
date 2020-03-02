package com.bishwajeet.starwarsapp.di

import android.content.Context
import com.bishwajeet.starwarsapp.model.source.remote.APIService
import com.bishwajeet.starwarsapp.view.pilot.fragmentPilot.PilotComponent
import com.bishwajeet.starwarsapp.view.pilot.fragmentPilotDetail.PilotDetailComponent
import com.bishwajeet.starwarsapp.view.settings.SettingsComponent
import com.bishwajeet.starwarsapp.view.starship.fragmentStarship.StarshipComponent
import com.bishwajeet.starwarsapp.view.starship.fragmentStarshipDetail.StarshipDetailComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [ApplicationModule::class, ViewModelBuilderModule::class, SubcomponentsModule::class]
)
interface ApplicationComponent {

    /*
    * Makes DependencyGraph ito be available to other Android framework classes
    * */
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }


    /*
    * Components & SubComponents
    * */
    fun starshipComponent(): StarshipComponent.Factory

    fun starshipDetailComponent(): StarshipDetailComponent.Factory

    fun pilotComponent(): PilotComponent.Factory

    fun pilotDetailComponent(): PilotDetailComponent.Factory

    fun settingsComponent(): SettingsComponent.Factory


    /*
    * Return single instance
    * */
    val networkService: APIService
}