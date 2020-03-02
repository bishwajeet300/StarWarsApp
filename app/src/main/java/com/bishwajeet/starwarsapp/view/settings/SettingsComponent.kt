package com.bishwajeet.starwarsapp.view.settings

import dagger.Subcomponent

@Subcomponent(modules = [SettingsModule::class])
interface SettingsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingsComponent
    }


    fun inject(fragment: SettingsFragment)
}