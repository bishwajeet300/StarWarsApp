package com.bishwajeet.starwarsapp.view.starship.fragmentStarshipDetail

import dagger.Subcomponent

@Subcomponent(modules = [StarshipDetailModule::class])
interface StarshipDetailComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): StarshipDetailComponent
    }


    fun inject(fragment: StarshipDetailFragment)
}