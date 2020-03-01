package com.bishwajeet.starwarsapp.model.repository

import androidx.lifecycle.LiveData
import com.bishwajeet.starwarsapp.model.entity.Starship
import com.bishwajeet.starwarsapp.model.entity.StarshipWithPilots

interface StarshipRepository {

    suspend fun getStarshipList(): LiveData<MutableList<Starship>>

    suspend fun getStarshipsWithPilot(): LiveData<MutableList<StarshipWithPilots>>

    suspend fun getStarship(starship_id: String): LiveData<StarshipWithPilots>
}