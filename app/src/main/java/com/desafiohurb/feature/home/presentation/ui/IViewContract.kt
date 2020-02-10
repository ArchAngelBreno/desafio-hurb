package com.desafiohurb.feature.home.presentation.ui

import com.desafiohurb.data.hotel.domain.ResultDomain

interface IViewContract {

    fun showSucces(results: List<ResultDomain>)

    fun showError()

    fun showLoading()

}
