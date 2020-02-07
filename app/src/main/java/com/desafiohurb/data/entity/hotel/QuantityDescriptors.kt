package com.desafiohurb.data.entity.hotel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QuantityDescriptors(
    @Json(name = "maxAdults")
    val maxAdults: Int? = null,
    @Json(name = "maxChildren")
    val maxChildren: Int? = null,
    @Json(name = "maxFreeChildrenAge")
    val maxFreeChildrenAge: Int? = null
)