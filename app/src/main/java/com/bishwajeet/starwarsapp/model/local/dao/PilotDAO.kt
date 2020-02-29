package com.bishwajeet.starwarsapp.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.bishwajeet.starwarsapp.model.local.entity.PilotWithStarships

@Dao
interface PilotDAO {

    @Transaction
    @Query("SELECT * FROM TABLE_PILOT")
    suspend fun getPilotWithStarships(): LiveData<List<PilotWithStarships>>
}