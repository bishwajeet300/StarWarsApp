package com.bishwajeet.starwarsapp.view.starship.fragmentStarshipDetail

import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class StarshipDetailModule {

    @Binds
    @IntoMap
    @ViewModelKey(StarshipDetailViewModel::class)
    abstract fun bindViewModel(viewModel: StarshipDetailViewModel): ViewModel
}