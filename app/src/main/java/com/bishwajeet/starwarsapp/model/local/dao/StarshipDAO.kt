package com.bishwajeet.starwarsapp.model.local.dao

import androidx.room.*
import com.bishwajeet.starwarsapp.model.local.entity.Pilot
import com.bishwajeet.starwarsapp.model.local.entity.Starship
import com.bishwajeet.starwarsapp.model.local.entity.StarshipWithPilots

@Dao
interface StarshipDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStarshipAndPilots(starship: Starship, pilots: List<Pilot>)


    @Transaction
    @Query("SELECT * FROM TABLE_STARSHIP")
    fun getStarshipWithPilots(): List<StarshipWithPilots>
}