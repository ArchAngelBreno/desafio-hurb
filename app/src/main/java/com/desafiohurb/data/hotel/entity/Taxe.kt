package com.desafiohurb.data.hotel.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Taxe(
    @Json(name = "amount")
    val amount: Double? = null,
    @Json(name = "amount_original")
    val amountOriginal: Double? = null,
    @Json(name = "currency")
    val currency: String? = null,
    @Json(name = "currency_original")
    val currencyOriginal: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "type")
    val type: String? = null
)