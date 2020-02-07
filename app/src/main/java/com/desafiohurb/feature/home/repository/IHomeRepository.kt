package com.desafiohurb.feature.home.repository

import com.desafiohurb.data.entity.hotel.Result

interface IHomeRepository {


    suspend fun retrieveHotels(page: Int): List<Result>?
}
