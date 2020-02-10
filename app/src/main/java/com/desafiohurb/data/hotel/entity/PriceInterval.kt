package com.desafiohurb.data.hotel.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PriceInterval(
    @Json(name = "filterPattern")
    val filterPattern: String? = null,
    @Json(name = "max")
    val max: Int? = null,
    @Json(name = "min")
    val min: Int? = null
)