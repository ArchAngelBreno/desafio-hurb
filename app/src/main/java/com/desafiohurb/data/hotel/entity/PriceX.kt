package com.desafiohurb.data.hotel.entity


import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PriceX(
    @Json(name = "amount")
    val amount: Double? = null,
    @Json(name = "amountPerDay")
    val amountPerDay: Double? = null,
    @Json(name = "currency")
    val currency: String? = null,
    @Json(name = "currency_original")
    val currencyOriginal: String? = null,
    @Json(name = "current_price")
    val currentPrice: Double? = null,
    @Json(name = "fee_extra")
    val feeExtra: Int? = null,
    @Json(name = "fee_extra_original")
    val feeExtraOriginal: Int? = null,
    @Json(name = "gain")
    val gain: Int? = null,
    @Json(name = "gain_original")
    val gainOriginal: Int? = null,
    @Json(name = "old_price")
    val oldPrice: Double? = null,
    @Json(name = "originalAmountPerDay")
    val originalAmountPerDay: Double? = null,
    @Json(name = "sku")
//    @ColumnInfo(name = "price_sku")
    val sku: String? = null,
    @Json(name = "tariff_policies")
    val tariffPolicies: List<String>? = null,
    @Json(name = "taxes")
    val taxes: List<Taxe>? = null,
    @Json(name = "total_price")
    val totalPrice: Double? = null
)