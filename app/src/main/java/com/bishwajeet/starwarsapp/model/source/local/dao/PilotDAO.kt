package com.bishwajeet.starwarsapp.model.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bishwajeet.starwarsapp.model.entity.Pilot
import com.bishwajeet.starwarsapp.model.entity.PilotWithStarships
import com.bishwajeet.starwarsapp.model.entity.Starship

@Dao
interface PilotDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPilots(pilots: LiveData<MutableList<Pilot>>): Boolean


    @Transaction
    @Query("SELECT * FROM TABLE_PILOT")
    suspend fun getPilotList(page: Int): LiveData<MutableList<Pilot>>


    @Transaction
    @Query("SELECT * FROM TABLE_PILOT")
    suspend fun getPilot(pilot_id: Int): LiveData<Pilot>
}