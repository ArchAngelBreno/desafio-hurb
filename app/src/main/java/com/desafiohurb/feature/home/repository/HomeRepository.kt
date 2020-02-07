package com.desafiohurb.feature.home.repository

import com.desafiohurb.data.entity.hotel.Result
import com.desafiohurb.data.source.remote.hotel.HotelService

class HomeRepository(
    private val hotelService: HotelService
//    private val hotelDao: HotelDao
): IHomeRepository {


    override suspend fun retrieveHotels(page: Int): List<Result>? {
        val homeResponse = hotelService.getHotels(page = page)
        return homeResponse.results
    }
}