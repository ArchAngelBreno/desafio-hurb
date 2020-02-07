package com.desafiohurb.data.entity.hotel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeaturedItem(
    @Json(name = "amenities")
    val amenities: List<String?>? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "name")
    val name: String? = null
)