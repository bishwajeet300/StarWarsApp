package com.bishwajeet.starwarsapp.model.repository

import androidx.lifecycle.LiveData
import com.bishwajeet.starwarsapp.model.entity.Pilot
import com.bishwajeet.starwarsapp.model.entity.PilotWithStarships


interface PilotRepository {

    suspend fun getPilotList(): LiveData<MutableList<Pilot>>

    suspend fun getPilotsWithStarship(): LiveData<MutableList<PilotWithStarships>>

    suspend fun getPilot(pilot_id: String): LiveData<PilotWithStarships>
}