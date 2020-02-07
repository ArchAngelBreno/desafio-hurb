package com.desafiohurb.data.entity.hotel


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "address")
    val address: Address? = null,
    @Json(name = "amenities")
    val amenities: List<AmenityX?>? = null,
    @Json(name = "category")
    val category: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "featuredItem")
    val featuredItem: FeaturedItem? = null,
    @Json(name = "gallery")
    val gallery: List<Gallery?>? = null,
    @Json(name = "hu_free_cancellation")
    val huFreeCancellation: Boolean? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "isHotel")
    val isHotel: Boolean? = null,
    @Json(name = "isPackage")
    val isPackage: Boolean? = null,
    @Json(name = "isTicket")
    val isTicket: Boolean? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "price")
    val price: PriceX? = null,
    @Json(name = "quantityDescriptors")
    val quantityDescriptors: QuantityDescriptors? = null,
    @Json(name = "sku")
    val sku: String? = null,
    @Json(name = "smallDescription")
    val smallDescription: String? = null,
    @Json(name = "stars")
    val stars: Int? = null,
    @Json(name = "tags")
    val tags: List<Any?>? = null,
    @Json(name = "url")
    val url: String? = null
)