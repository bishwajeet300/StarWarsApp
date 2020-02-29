package com.bishwajeet.starwarsapp.view.fragmentStarship

import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class StarshipModule {

    @Binds
    @IntoMap
    @ViewModelKey(StarshipViewModel::class)
    abstract fun bindViewModel(viewModel: StarshipViewModel): ViewModel
}