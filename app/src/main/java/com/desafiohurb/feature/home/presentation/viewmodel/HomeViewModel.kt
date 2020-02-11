package com.desafiohurb.feature.home.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.desafiohurb.core.base.BaseViewModel
import com.desafiohurb.core.helper.Resource
import com.desafiohurb.data.hotel.domain.ResultDomain
import com.desafiohurb.feature.home.repository.HomeRepository

class HomeViewModel(
    private val homeRepository: HomeRepository
) : BaseViewModel(), IHomeViewModel {


    var currentPage = 1
    var isLoading = true

    private val hotelsMutableLiveData = MutableLiveData<Resource<List<ResultDomain>>>()

    val hotelsLiveData: LiveData<Resource<List<ResultDomain>>> by lazy {
        hotelsMutableLiveData
    }

    private val hotelsList = mutableListOf<ResultDomain>()

    init {
        fetchHotels()
    }


    override fun fetchHotels(page: Int) {
        hotelsMutableLiveData.loading()
        viewModelScope.launchWithCallback(
            onSuccess = {
                homeRepository.retrieveHotels(page)?.let {
                    if (!it.isNullOrEmpty()) {
                        hotelsList.addAll(it)
                        hotelsMutableLiveData.success(hotelsList)
                    }
                }
            },
            onError = { t ->
                hotelsMutableLiveData.error(t)
            }
        )
    }

    override fun nextPage() {
        fetchHotels(++currentPage)
    }


    override fun refreshViewModel() {
        currentPage = 1
        fetchHotels()
    }
}