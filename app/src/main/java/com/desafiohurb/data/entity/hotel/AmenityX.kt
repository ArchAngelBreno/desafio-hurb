package com.desafiohurb.data.entity.hotel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AmenityX(
    @Json(name = "category")
    val category: String? = null,
    @Json(name = "name")
    val name: String? = null
)