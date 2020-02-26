package com.bishwajeet.starwarsapp.model.local.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class PilotWithStarships(

    @Embedded val pilot: Pilot,
    @Relation(
        parentColumn = "pilot_id",
        entityColumn = "starship_id",
        associateBy = Junction(StarshipPilotRelationship::class)
    ) val starships: List<Starship>
)