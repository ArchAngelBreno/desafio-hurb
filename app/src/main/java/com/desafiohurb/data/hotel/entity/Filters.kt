package com.desafiohurb.data.hotel.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Filters(
    @Json(name = "amenities")
    val amenities: List<Amenity?>? = null,
    @Json(name = "attributes")
    val attributes: List<Attribute?>? = null,
    @Json(name = "cities")
    val cities: List<City?>? = null,
    @Json(name = "countries")
    val countries: List<Country?>? = null,
    @Json(name = "departureCities")
    val departureCities: List<DepartureCity?>? = null,
    @Json(name = "duration")
    val duration: List<Duration?>? = null,
    @Json(name = "food")
    val food: List<Food?>? = null,
    @Json(name = "people")
    val people: List<People?>? = null,
    @Json(name = "priceInterval")
    val priceInterval: PriceInterval? = null,
    @Json(name = "prices")
    val prices: List<Price?>? = null,
    @Json(name = "productType")
    val productType: List<ProductType?>? = null,
    @Json(name = "regulation")
    val regulation: List<Regulation?>? = null,
    @Json(name = "rooms")
    val rooms: List<Room?>? = null,
    @Json(name = "stars")
    val stars: List<Star?>? = null,
    @Json(name = "states")
    val states: List<State?>? = null
)