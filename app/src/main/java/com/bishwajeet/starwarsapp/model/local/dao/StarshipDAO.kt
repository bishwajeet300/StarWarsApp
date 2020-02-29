package com.bishwajeet.starwarsapp.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bishwajeet.starwarsapp.model.local.entity.Pilot
import com.bishwajeet.starwarsapp.model.local.entity.Starship
import com.bishwajeet.starwarsapp.model.local.entity.StarshipWithPilots

@Dao
interface StarshipDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarshipAndPilots(starship: Starship, pilots: List<Pilot>)


    @Transaction
    @Query("SELECT * FROM TABLE_STARSHIP")
    suspend fun getStarshipWithPilots(): LiveData<List<StarshipWithPilots>>
}