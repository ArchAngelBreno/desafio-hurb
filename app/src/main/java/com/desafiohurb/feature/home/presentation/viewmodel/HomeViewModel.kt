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

    init {
        fetchHotels()
    }


    override fun fetchHotels(page: Int) {
        hotelsMutableLiveData.loading()
        viewModelScope.launchWithCallback(
            onSuccess = {
                homeRepository.retrieveHotels(page)?.let {
                    if (!it.isNullOrEmpty()) {
                        hotelsMutableLiveData.success(it)
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
        isLoading = false
    }


    override fun refreshViewModel() {
        currentPage = 1
        fetchHotels()
    }
}