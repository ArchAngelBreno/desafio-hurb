package com.desafiohurb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.desafiohurb.core.helper.observeResource
import com.desafiohurb.feature.home.presentation.viewmodel.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val homeViewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        homeViewModel.hotelsLiveData.observeResource(this,
            onSuccess = {
               Timber.tag(it[0].name)
            },
            onLoading = {

            },
            onError = {

            })
    }
}
