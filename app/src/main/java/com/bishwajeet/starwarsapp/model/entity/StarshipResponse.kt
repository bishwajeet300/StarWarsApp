package com.bishwajeet.starwarsapp.model.entity
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class StarshipResponse(
    @Json(name = "count")
    val count: Int = 0,
    @Json(name = "next")
    val next: String = "",
    @Json(name = "previous")
    val previous: Any? = Any(),
    @Json(name = "results")
    val results: List<Starship> = listOf()
)