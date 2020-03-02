package com.bishwajeet.starwarsapp.di

import com.bishwajeet.starwarsapp.view.pilot.fragmentPilot.PilotComponent
import com.bishwajeet.starwarsapp.view.pilot.fragmentPilotDetail.PilotDetailComponent
import com.bishwajeet.starwarsapp.view.settings.SettingsComponent
import com.bishwajeet.starwarsapp.view.starship.fragmentStarship.StarshipComponent
import com.bishwajeet.starwarsapp.view.starship.fragmentStarshipDetail.StarshipDetailComponent
import dagger.Module

@Module(
    subcomponents = [
        StarshipComponent::class,
        StarshipDetailComponent::class,
        PilotComponent::class,
        PilotDetailComponent::class,
        SettingsComponent::class
    ]
)
object SubcomponentsModule