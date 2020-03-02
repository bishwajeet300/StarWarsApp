package com.bishwajeet.starwarsapp.view.pilot.fragmentPilotDetail

import dagger.Subcomponent

@Subcomponent(modules = [PilotDetailModule::class])
interface PilotDetailComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PilotDetailComponent
    }


    fun inject(fragment: PilotDetailsFragment)
}