package com.bishwajeet.starwarsapp.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bishwajeet.starwarsapp.model.local.dao.PilotDAO
import com.bishwajeet.starwarsapp.model.local.dao.StarshipDAO
import com.bishwajeet.starwarsapp.model.local.entity.Pilot
import com.bishwajeet.starwarsapp.model.local.entity.Starship
import com.bishwajeet.starwarsapp.model.local.entity.StarshipPilotRelationship

@Database(entities = [Starship::class, Pilot::class, StarshipPilotRelationship::class], version = 1, exportSchema = false)
abstract class StarWarsDB: RoomDatabase() {

    abstract fun starshipDAO(): StarshipDAO
    abstract fun pilotDAO(): PilotDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: StarWarsDB? = null

        fun getDatabase(context: Context): StarWarsDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StarWarsDB::class.java,
                    "starwars_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}