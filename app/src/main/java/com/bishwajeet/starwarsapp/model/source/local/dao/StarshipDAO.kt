package com.bishwajeet.starwarsapp.model.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bishwajeet.starwarsapp.model.entity.Starship
import com.bishwajeet.starwarsapp.model.entity.StarshipWithPilots

@Dao
interface StarshipDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarships(starship: LiveData<MutableList<Starship>>): Boolean


    @Transaction
    @Query("SELECT * FROM TABLE_STARSHIP")
    suspend fun getStarshipList(page: Int): LiveData<MutableList<Starship>>


    @Transaction
    @Query("SELECT * FROM TABLE_STARSHIP")
    suspend fun getStarship(starship_id: Int): LiveData<Starship>
}