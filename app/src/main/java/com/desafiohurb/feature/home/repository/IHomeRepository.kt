package com.desafiohurb.feature.home.repository

import com.desafiohurb.data.hotel.domain.ResultDomain

interface IHomeRepository {


    suspend fun retrieveHotels(page: Int): List<ResultDomain>?
}
