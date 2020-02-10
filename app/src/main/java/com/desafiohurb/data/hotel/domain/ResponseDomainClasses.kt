package com.desafiohurb.data.hotel.domain

import android.text.TextUtils

data class ResultDomain(
    val hotelName: String?,
    val smallDescription: String?,
    val description: String?,
    val amenityDomain: List<AmenityDomain>,
    val stars: Int?,
    val hotelOldPrice: Double?,
    val hotelCurrentPrice: Double?,
    val taxeDomain: List<TaxeDomain>,
    val hotelBannerImage: String?,
    val tags: List<String>?,
    val address: AddressDomain?) {

    fun isValid(): Boolean {
        return hotelName != "" && hotelCurrentPrice != null && hotelOldPrice != null
                && address != null && hotelBannerImage != "" && stars!! > 0
    }
}

data class AddressDomain(
    val streetName: String?,
    val country: String?,
    val neighborhood: String?,
    val city: String?,
    val state: String?,
    val zipcode: String?
)

data class AmenityDomain(val name: String?, val category: String?)


data class TaxeDomain(val name: String?, val amount: Double?)



