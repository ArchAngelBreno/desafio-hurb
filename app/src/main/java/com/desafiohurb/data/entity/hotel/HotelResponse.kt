package com.desafiohurb.data.entity.hotel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HotelResponse(
    @Json(name = "filters")
    val filters: Filters? = null,
    @Json(name = "meta")
    val meta: Meta? = null,
    @Json(name = "pagination")
    val pagination: Pagination? = null,
    @Json(name = "results")
    val results: List<Result>? = null
)