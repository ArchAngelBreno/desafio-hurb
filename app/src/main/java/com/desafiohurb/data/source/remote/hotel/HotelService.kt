package com.desafiohurb.data.source.remote.hotel

import com.desafiohurb.core.base.BaseService
import com.desafiohurb.data.entity.hotel.HotelResponse

class HotelService: BaseService() {

    suspend fun getHotels(query: String = "buzios", page: Int): HotelResponse {
        return apiService.getHotels(query, page)
    }

}
