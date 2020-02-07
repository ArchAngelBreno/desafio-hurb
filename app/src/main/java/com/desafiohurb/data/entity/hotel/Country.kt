package com.desafiohurb.data.entity.hotel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country(
    @Json(name = "count")
    val count: Int? = null,
    @Json(name = "filter")
    val filter: String? = null,
    @Json(name = "term")
    val term: String? = null
)