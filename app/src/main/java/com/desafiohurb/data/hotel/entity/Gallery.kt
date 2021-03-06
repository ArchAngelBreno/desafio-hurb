package com.desafiohurb.data.hotel.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Gallery(
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "url")
    val url: String? = null
)