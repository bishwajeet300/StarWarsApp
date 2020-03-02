package com.bishwajeet.starwarsapp.view.pilot.fragmentPilot

import dagger.Subcomponent


@Subcomponent(modules = [PilotModule::class])
interface PilotComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PilotComponent
    }

    fun inject(fragment: PilotFragment)
}