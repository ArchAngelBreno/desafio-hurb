package com.desafiohurb.data.hotel.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "count")
    val count: Int? = null,
    @Json(name = "countBustrip")
    val countBustrip: Int? = null,
    @Json(name = "countDisney")
    val countDisney: Int? = null,
    @Json(name = "countHotel")
    val countHotel: Int? = null,
    @Json(name = "countPackage")
    val countPackage: Int? = null,
    @Json(name = "countTicket")
    val countTicket: Int? = null,
    @Json(name = "countWithAvailabilityInPage")
    val countWithAvailabilityInPage: Int? = null,
    @Json(name = "offset")
    val offset: Int? = null,
    @Json(name = "query")
    val query: String? = null,
    @Json(name = "warning")
    val warning: String? = null
)