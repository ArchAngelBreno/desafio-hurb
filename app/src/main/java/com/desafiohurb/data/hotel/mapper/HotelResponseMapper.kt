package com.desafiohurb.data.hotel.mapper

import com.desafiohurb.data.hotel.domain.AddressDomain
import com.desafiohurb.data.hotel.domain.AmenityDomain
import com.desafiohurb.data.hotel.domain.ResultDomain
import com.desafiohurb.data.hotel.domain.TaxeDomain
import com.desafiohurb.data.hotel.entity.Address
import com.desafiohurb.data.hotel.entity.AmenityX
import com.desafiohurb.data.hotel.entity.Result
import com.desafiohurb.data.hotel.entity.Taxe

object HotelResponseMapper {

    fun transformEntityToDomain(resultsResponse: List<Result>?): List<ResultDomain>? {
        val resultsDomain = ArrayList<ResultDomain>()

        resultsResponse?.let { results ->
            results.forEach {
                val resultDomain = ResultDomain(
                    it.name,
                    it.smallDescription,
                    it.description,
                    transformAmenitiesEntityToDomain(it.amenities),
                    it.stars,
                    it.price?.originalAmountPerDay,
                    it.price?.amountPerDay,
                    transformTaxesEntityToDomain(it.price?.taxes),
                    it.image,
                    it.tags,
                    transformAddressEntityToDomain(it.address)
                )

                resultsDomain.add(resultDomain)

            }
        }

        return resultsDomain

    }

    private fun transformAddressEntityToDomain(address: Address?): AddressDomain {
        return AddressDomain(
            address?.streetName, address?.country, address?.neighborhood,
            address?.city, address?.state, address?.zipcode
        )
    }

    private fun transformTaxesEntityToDomain(taxes: List<Taxe>?): List<TaxeDomain> {
        val taxesDomain = ArrayList<TaxeDomain>()

        taxes?.let {
            it.forEach { taxe ->
                val taxeDomain = TaxeDomain(taxe.name, taxe.amount)
                taxesDomain.add(taxeDomain)
            }
        }

        return taxesDomain

    }

    private fun transformAmenitiesEntityToDomain(amenities: List<AmenityX>?): List<AmenityDomain> {
        val amenitiesDomain = ArrayList<AmenityDomain>()

        amenities?.let {
            it.forEach { amenity ->
                val amenityDomain = AmenityDomain(amenity.name, amenity.category)
                amenitiesDomain.add(amenityDomain)
            }
        }

        return amenitiesDomain
    }
}

