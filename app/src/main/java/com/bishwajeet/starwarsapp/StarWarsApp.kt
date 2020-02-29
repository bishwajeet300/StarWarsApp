package com.bishwajeet.starwarsapp

import android.app.Application


class StarWarsApp: Application() {

    val applicationComponent = DaggerApplicationComponent().create()
}