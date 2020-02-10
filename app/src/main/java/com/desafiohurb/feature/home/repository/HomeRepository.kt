package com.desafiohurb.feature.home.repository

import com.desafiohurb.core.base.BaseRepository
import com.desafiohurb.data.hotel.domain.ResultDomain
import com.desafiohurb.data.hotel.entity.Result
import com.desafiohurb.data.hotel.mapper.HotelResponseMapper
import com.desafiohurb.data.source.local.HotelDao
import com.desafiohurb.data.source.remote.hotel.HotelService

class HomeRepository(
    private val hotelService: HotelService
//    private val hotelDao: HotelDao
) : IHomeRepository, BaseRepository() {


    override suspend fun retrieveHotels(page: Int): List<ResultDomain>? {
        return networkBoundResource(
            makeApiCall = {
               hotelService.getHotels(page = page)
            },
            saveCallResult = {
                it?.let { results ->
//                    hotelDao.insert(results)
                }
            },
            shouldFetch = {
                true
            },
            loadFromDb = {
                null
            }).transform { HotelResponseMapper.transformEntityToDomain(it) }
    }
}