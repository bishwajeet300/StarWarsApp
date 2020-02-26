package com.bishwajeet.starwarsapp.model.local.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class StarshipWithPilots(

    @Embedded val starship: Starship,
    @Relation(
        parentColumn = "starship_id",
        entityColumn = "pilot_id",
        associateBy = Junction(StarshipPilotRelationship::class)
    ) val pilots: List<Pilot>
)