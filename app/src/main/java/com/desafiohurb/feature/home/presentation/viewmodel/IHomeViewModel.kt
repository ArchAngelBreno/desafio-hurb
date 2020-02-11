package com.desafiohurb.feature.home.presentation.viewmodel

interface IHomeViewModel {


    fun fetchHotels(page: Int = 1)
    fun nextPage()
    fun refreshViewModel()
}