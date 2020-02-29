package com.bishwajeet.starwarsapp.di

import android.content.Context
import com.bishwajeet.starwarsapp.model.repository.PilotRepository
import com.bishwajeet.starwarsapp.model.repository.StarshipRepository
import com.bishwajeet.starwarsapp.view.fragmentStarship.StarshipComponent
import com.bishwajeet.starwarsapp.view.fragmentStarship.StarshipDetailComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [ApplicationModule::class, ViewModelBuilderModule::class, SubcomponentsModule::class]//TODO: All Modules
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


    /*
    * Return single instance
    * */
    val starshipRepository: StarshipRepository
    val pilotRepository: PilotRepository
}