package com.bishwajeet.starwarsapp.view.pilot.fragmentPilot

import androidx.lifecycle.ViewModel
import com.bishwajeet.starwarsapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PilotModule {

    @Binds
    @IntoMap
    @ViewModelKey(PilotViewModel::class)
    abstract fun bindViewModel(viewModel: PilotViewModel): ViewModel
}