package com.bishwajeet.starwarsapp.view.fragmentStarship

import dagger.Subcomponent

@Subcomponent(modules = [StarshipModule::class])
interface StarshipComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): StarshipComponent
    }


    fun inject(fragment: StarshipFragment)
}