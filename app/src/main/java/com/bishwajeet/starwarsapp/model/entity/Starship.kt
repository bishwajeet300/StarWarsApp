package com.bishwajeet.starwarsapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_starship")
data class Starship(

    @PrimaryKey
    @ColumnInfo(name = "starship_id")
    val url: String,

    val name: String,
    val model: String,
    val manufacturer: String,
    val cost_in_credits: String,
    val length: String,
    val max_atmosphering_speed: String,
    val crew: String,
    val passengers: String,
    val cargo_capacity: String,
    val consumables: String,
    val hyperdrive_rating: String,
    val MGLT: String,
    val starship_class: String,
    val created: String,
    val edited: String
)