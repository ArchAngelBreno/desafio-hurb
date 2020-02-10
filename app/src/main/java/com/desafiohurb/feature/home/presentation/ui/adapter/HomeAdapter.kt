package com.desafiohurb.feature.home.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafiohurb.R
import com.desafiohurb.data.hotel.domain.ResultDomain
import kotlinx.android.synthetic.main.hotel_item.view.*

class HomeAdapter(private val hotels: ArrayList<ResultDomain>?): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hotel_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hotels?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hotelItem = hotels?.get(position)

        holder.itemView.hotelItemName.text = hotelItem?.hotelName

    }




    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }



}
