package com.reptil.panda.cryptocurrencytrading.ui


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.reptil.panda.cryptocurrencytrading.model.CoinModel
import com.reptil.panda.cryptocurrencytrading.R

import java.util.ArrayList

class CoinModelAdapter : RecyclerView.Adapter<CoinModelViewHolder>() {

    private val items = ArrayList<CoinModel>()

    fun setData(newItems: List<CoinModel>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CoinModelViewHolder, position: Int) {
        holder.showData(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_layout, parent, false)

        return CoinModelViewHolder(view)
    }
}
