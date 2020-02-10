package com.desafiohurb.data.source.remote.hotel

import com.desafiohurb.core.base.BaseService
import com.desafiohurb.data.hotel.entity.HotelResponse
import com.desafiohurb.data.hotel.entity.Result

class HotelService: BaseService() {

    suspend fun getHotels(query: String = "buzios", page: Int): List<Result>? {
        val hotelResponse = apiService.getHotels(query, page)
        return hotelResponse.hotels
    }

}
