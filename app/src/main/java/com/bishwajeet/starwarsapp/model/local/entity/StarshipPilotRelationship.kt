package com.bishwajeet.starwarsapp.model.local.entity

import androidx.room.Entity

@Entity(primaryKeys = ["starship_id", "people_id"])
data class StarshipPilotRelationship(

    val starship_id: String,
    val people_id: String

)