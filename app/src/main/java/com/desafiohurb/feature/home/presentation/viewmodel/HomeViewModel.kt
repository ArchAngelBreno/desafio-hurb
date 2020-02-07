package com.desafiohurb.feature.home.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.desafiohurb.core.base.BaseViewModel
import com.desafiohurb.core.helper.Resource
import com.desafiohurb.data.entity.hotel.Result
import com.desafiohurb.feature.home.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeRepository: HomeRepository
) : BaseViewModel(), IHomeViewModel {


    private val hotelsMutableLiveData = MutableLiveData<Resource<List<Result>>>()
    val hotelsLiveData: LiveData<Resource<List<Result>>> by lazy {
        hotelsMutableLiveData
    }

    init {
        fetchHotels()
    }


    override fun fetchHotels(page: Int) {
        hotelsMutableLiveData.loading()

        viewModelScope.launch {
            try {
                homeRepository.retrieveHotels(page)?.let {
                    if (!it.isNullOrEmpty()) {
                        hotelsMutableLiveData.success(it)
                    }
                }
            } catch (t: Throwable) {
                hotelsMutableLiveData.error(t)
            }
        }
    }
}