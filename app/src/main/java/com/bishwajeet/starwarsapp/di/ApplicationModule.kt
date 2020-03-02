package com.bishwajeet.starwarsapp.di

import android.content.Context
import com.bishwajeet.starwarsapp.model.source.preferences.IPreferencesContract
import com.bishwajeet.starwarsapp.model.source.preferences.PreferencesDataSource
import com.bishwajeet.starwarsapp.model.source.remote.APIService
import com.bishwajeet.starwarsapp.model.source.remote.StarWarsAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class ApplicationModule {

    @Module
    companion object {

        @JvmStatic
        @Singleton
        @Provides
        fun provideAPIService(): APIService {
            return StarWarsAPI.retrofitService
        }


        @JvmStatic
        @Provides
        @Singleton
        fun providePreferencesManager(context: Context): IPreferencesContract =
            PreferencesDataSource(context)
    }
}