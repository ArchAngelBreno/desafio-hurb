package com.desafiohurb.data.hotel.entity


import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Address(
    @Json(name = "address")
    val address: String? = null,
    @Json(name = "city")
    val city: String? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "countryAlfa2")
    val countryAlfa2: String? = null,
    @Json(name = "fullAddress")
    val fullAddress: String? = null,
    @Json(name = "geoLocation")
    @Embedded
    val geoLocation: GeoLocation? = null,
    @Json(name = "id_atlas_city")
    val idAtlasCity: String? = null,
    @Json(name = "id_atlas_country")
    val idAtlasCountry: String? = null,
    @Json(name = "id_atlas_neighborhood")
    val idAtlasNeighborhood: String? = null,
    @Json(name = "id_atlas_state")
    val idAtlasState: String? = null,
    @Json(name = "id_city")
    val idCity: Int? = null,
    @Json(name = "id_country")
    val idCountry: Int? = null,
    @Json(name = "id_neighborhood")
    val idNeighborhood: String? = null,
    @Json(name = "id_state")
    val idState: Int? = null,
    @Json(name = "neighborhood")
    val neighborhood: String? = null,
    @Json(name = "state")
    val state: String? = null,
    @Json(name = "street")
    val street: String? = null,
    @Json(name = "street_name")
    val streetName: String? = null,
    @Json(name = "zipcode")
    val zipcode: String? = null
)