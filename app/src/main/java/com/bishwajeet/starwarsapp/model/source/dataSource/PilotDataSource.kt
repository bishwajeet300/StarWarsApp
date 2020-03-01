package com.bishwajeet.starwarsapp.model.source.dataSource

import androidx.lifecycle.LiveData
import com.bishwajeet.starwarsapp.model.entity.Pilot

interface PilotDataSource {

    suspend fun getPilotList(page: Int): LiveData<MutableList<Pilot>>

    suspend fun getPilot(pilot_id: Int): LiveData<Pilot>
}