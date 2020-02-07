package com.desafiohurb.core.base

import com.desafiohurb.data.source.remote.ApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class BaseService {

    companion object {
        private const val BASE_API = "https://www.hurb.com/search/"
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val getRetrofitInstance = Retrofit.Builder()
        .baseUrl(BASE_API)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()

    val apiService : ApiClient = getRetrofitInstance.create(ApiClient::class.java)

}
