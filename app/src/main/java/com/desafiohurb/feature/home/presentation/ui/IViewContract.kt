package com.desafiohurb.feature.home.presentation.ui

import com.desafiohurb.data.hotel.domain.ResultDomain

interface IViewContract {

    fun showSuccess(results: List<ResultDomain>)

    fun showError(error: Throwable)

    fun showLoading()

}
