package com.desafiohurb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafiohurb.core.helper.observeResource
import com.desafiohurb.data.hotel.domain.ResultDomain
import com.desafiohurb.feature.home.presentation.ui.IViewContract
import com.desafiohurb.feature.home.presentation.ui.adapter.HomeAdapter
import com.desafiohurb.feature.home.presentation.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), IViewContract {

    private val homeViewModel by viewModel<HomeViewModel>()
    private val hotels = ArrayList<ResultDomain>()

    private val homeAdapter: HomeAdapter by lazy {
            HomeAdapter(hotels)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        homeViewModel.hotelsLiveData.observeResource(this,
            onSuccess = {
                showSucces(it)
            },
            onLoading = {
//                showLoading()
            },
            onError = {
                showError()
            })
    }

    override fun showSucces(results: List<ResultDomain>) {
        with(hotelsRecyclerView) {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)

        }
        hotels.addAll(results)
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
