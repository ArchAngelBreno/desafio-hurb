package com.desafiohurb.core.di.module

import com.desafiohurb.core.base.BaseService
import com.desafiohurb.feature.home.repository.HomeRepository
import com.desafiohurb.data.source.remote.ApiClient
import com.desafiohurb.data.source.remote.hotel.HotelService
import com.desafiohurb.feature.home.presentation.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> {
        HomeRepository(
            get()
//            get()
        )
    }
}

val daoModule = module {
//    single<AppDatabase> { AppDatabase.getInstance(get()) }
//    single<HotelDao> {get<AppDatabase>().hotelDao()}
}

val viewModelModule = module {
    viewModel<HomeViewModel> { HomeViewModel(get()) }
}

val serviceModule = module {
    factory<ApiClient> { BaseService().apiService}
    single<HotelService> {HotelService()}
}