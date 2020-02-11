package com.desafiohurb.feature.home.presentation.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.desafiohurb.R
import com.desafiohurb.core.helper.PaginationScroll
import com.desafiohurb.core.helper.observeResource
import com.desafiohurb.data.hotel.domain.ResultDomain
import com.desafiohurb.feature.home.presentation.ui.adapter.HomeAdapter
import com.desafiohurb.feature.home.presentation.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : Fragment(), IViewContract {

    private val homeViewModel by viewModel<HomeViewModel>()

    private val homeAdapter: HomeAdapter by lazy {
            HomeAdapter(
                onItemClickListener = {
                    Timber.tag("Implementar")
                },
                onRetryClickListener = {
                    errorBottomScroll(false)
                })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        swipeRefresh()
    }

    private fun initUi() {
        homeViewModel.hotelsLiveData.observeResource(this,
            onSuccess = {
                showSuccess(it)
            },
            onLoading = {
                if (homeViewModel.isLoading) {
                    showLoading()
                }
            },
            onError = {
                showError(it)
            })
    }

    override fun showSuccess(results: List<ResultDomain>) {
        homeProgressBar.visibility = View.GONE
        with(hotelsRecyclerView) {
            this.visibility = View.VISIBLE
            adapter = homeAdapter
            val layoutManager = GridLayoutManager(this@HomeFragment.context, 2 )
            this.addOnScrollListener(object : PaginationScroll(layoutManager = layoutManager) {
                override fun loadMoreItems() {
                    homeViewModel.nextPage()
                }

                override fun isLoading(): Boolean {
                    return homeViewModel.isLoading
                }

                override fun getTotalPageCount(): Int {
                    return 0
                }

                override fun isLastPage(): Boolean {
                    return false
                }

                override fun hideOthersItems() {
//                    include_layout_loading_full_screen.visibility = View.GONE
                }
            })

            this.layoutManager = layoutManager

        }
        homeAdapter.addList(results)
    }

    override fun showError(error: Throwable) {
        Timber.e(error, error.message)
        homeProgressBar.visibility = View.GONE
        if (homeViewModel.currentPage > 1) {
            errorBottomScroll(true)
        } else {
            errorFullScreen()
        }
    }

    private fun errorFullScreen() {

    }

    override fun showLoading() {
        hotelsRecyclerView.visibility = View.GONE
        homeProgressBar.visibility = View.VISIBLE
    }

    private fun refresh() {
        homeAdapter.clearList()
        homeViewModel.fetchHotels(1)
    }

    private fun swipeRefresh() {
        swipeToRefresh.setOnRefreshListener {
            Handler().postDelayed({
                refresh()
                swipeToRefresh.isRefreshing = false
            }, 1000)
        }
    }

    private fun errorBottomScroll(showError: Boolean) {
        homeAdapter.showErrorRetry(showError)
    }
}
