package com.bishwajeet.starwarsapp.model.source.dataSource

import androidx.lifecycle.LiveData
import com.bishwajeet.starwarsapp.model.entity.Starship

interface StarshipDataSource {

    suspend fun getStarshipList(page: Int): LiveData<MutableList<Starship>>

    suspend fun getStarship(starship_id: Int): LiveData<Starship>
}