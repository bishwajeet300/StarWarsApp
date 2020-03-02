package com.bishwajeet.starwarsapp.model.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Pilot(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "height")
    val height: String = "",
    @Json(name = "mass")
    val mass: String = "",
    @Json(name = "hair_color")
    val hairColor: String = "",
    @Json(name = "skin_color")
    val skinColor: String = "",
    @Json(name = "eye_color")
    val eyeColor: String = "",
    @Json(name = "birth_year")
    val birthYear: String = "",
    @Json(name = "gender")
    val gender: String = "",
    @Json(name = "homeworld")
    val homeworld: String = "",
    @Json(name = "films")
    val films: List<String> = listOf(),
    @Json(name = "species")
    val species: List<String> = listOf(),
    @Json(name = "vehicles")
    val vehicles: List<String> = listOf(),
    @Json(name = "starships")
    val starships: List<String> = listOf(),
    @Json(name = "created")
    val created: String = "",
    @Json(name = "edited")
    val edited: String = "",
    @Json(name = "url")
    val url: String = ""
)