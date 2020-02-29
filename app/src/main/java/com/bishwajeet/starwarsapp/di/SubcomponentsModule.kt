package com.bishwajeet.starwarsapp.di

import com.bishwajeet.starwarsapp.view.fragmentStarship.StarshipComponent
import com.bishwajeet.starwarsapp.view.fragmentStarship.StarshipDetailComponent
import dagger.Module

@Module(
    subcomponents = [
        StarshipComponent::class,
        StarshipDetailComponent::class
    ]
)
object SubcomponentsModule