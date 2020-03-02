package com.bishwajeet.starwarsapp.view.pilot.fragmentPilotDetail

import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PilotDetailModule {

    @Binds
    @IntoMap
    @ViewModelKey(PilotDetailsViewModel::class)
    abstract fun bindViewModel(viewModel: PilotDetailsViewModel): ViewModel
}