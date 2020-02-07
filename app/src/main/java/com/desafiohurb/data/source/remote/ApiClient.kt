package com.desafiohurb.data.source.remote

import com.desafiohurb.data.entity.hotel.HotelResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("api")
    suspend fun getHotels(@Query("q") query:String,
                          @Query("page") page: Int): HotelResponse
}