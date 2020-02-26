package com.bishwajeet.starwarsapp.model.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_pilot")
data class Pilot(

    @PrimaryKey
    @ColumnInfo(name = "pilot_id")
    val url: String,

    val name: String,
    val height: String,
    val mass: String,
    val hair_color: String,
    val skin_color: String,
    val eye_color: String,
    val birth_year: String,
    val gender: String,
    val homeworld: String,
    val created: String,
    val edited: String
)