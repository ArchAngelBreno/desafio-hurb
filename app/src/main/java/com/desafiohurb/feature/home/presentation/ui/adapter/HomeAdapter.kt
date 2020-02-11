package com.desafiohurb.feature.home.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.desafiohurb.R
import com.desafiohurb.core.customview.ItemReload
import com.desafiohurb.data.hotel.domain.ResultDomain
import kotlinx.android.synthetic.main.endless_item_scroll_view.view.*
import kotlinx.android.synthetic.main.hotel_item.view.*

class HomeAdapter(
    private val onItemClickListener: ((ResultDomain) -> Unit),
    private val onRetryClickListener: (() -> Unit)
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isLoadingAdded = false
    private var retryPageLoad = false
    private var hotels = ArrayList<ResultDomain>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.hotel_item, parent, false)
            ItemViewHolder(view)
        } else {
            EndlessItemViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.endless_item_scroll_view,
                    parent,
                    false
                ), onRetryClickListener
            )
        }
    }

    override fun getItemCount(): Int {
        return if (isLoadingAdded) {
            hotels.size + 1
        } else {
            hotels.size
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> {
                val dataItem = hotels[position]
                holder.bindView(dataItem)
            }
            is EndlessItemViewHolder -> {
                holder.bindView(retryPageLoad)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < hotels.size) ITEM else LOADING_OR_ERROR
    }

    fun addList(dataItem: List<ResultDomain>) {
        this.hotels.addAll(dataItem)

        addItemBottom()
        notifyDataSetChanged()
    }

    fun clearList() {
        isLoadingAdded = false
        this.hotels.clear()
        notifyDataSetChanged()
    }

    private fun addItemBottom() {
        isLoadingAdded = true
    }

    fun showErrorRetry(showError: Boolean) {
        retryPageLoad = showError
        notifyItemChanged(hotels.size, 1)
    }

    companion object {
        const val ITEM = 100
        const val LOADING_OR_ERROR = 101
    }

    inner class ItemViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindView(hotelItem: ResultDomain?) = with(itemView) {
            hotelCity.text = hotelItem?.address?.city
            hotelOldPrice.text = hotelItem?.hotelOldPrice.toString()
            hotelCurrentPrice.text = hotelItem?.hotelCurrentPrice.toString()

            Glide
                .with(context)
                .load(hotelItem?.hotelBannerImage)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(hotelImage)

            setOnClickListener {
                hotelItem?.let {
                    onItemClickListener.invoke(it)
                }
            }
        }
    }

    inner class EndlessItemViewHolder(
        private val view: View,
        private val onRetryClickListener: (() -> Unit)
    ) : RecyclerView.ViewHolder(view) {

        private val itemBottom: ItemReload = view.item_bottom

        fun bindView(retryPageLoad: Boolean) = with(view) {
            if (retryPageLoad) {
                itemBottom.showErrorRetry()
            } else {
                itemBottom.showLoading()
            }

            itemBottom.buttonRetry.setOnClickListener {
                onRetryClickListener.invoke()
            }
        }
    }
}
