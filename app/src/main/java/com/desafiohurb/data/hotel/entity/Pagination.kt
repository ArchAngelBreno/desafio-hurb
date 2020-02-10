package com.desafiohurb.data.hotel.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pagination(
    @Json(name = "count")
    val count: Int? = null,
    @Json(name = "firstPage")
    val firstPage: String? = null,
    @Json(name = "lastPage")
    val lastPage: String? = null,
    @Json(name = "nextPage")
    val nextPage: String? = null,
    @Json(name = "previousPage")
    val previousPage: Any? = null
)