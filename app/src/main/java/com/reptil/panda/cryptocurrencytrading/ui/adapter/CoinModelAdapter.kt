package com.reptil.panda.cryptocurrencytrading.ui.adapter


import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.reptil.panda.cryptocurrencytrading.model.CoinModel
import com.reptil.panda.cryptocurrencytrading.R
import com.reptil.panda.cryptocurrencytrading.ui.view.CoinModelViewHolder

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
        val coinModel = items.get(position)

        val item = holder as CoinModelViewHolder

        item.coinName.text = coinModel.name
        item.coinSymbol.text = coinModel.symbol
        item.coinPrice.text = coinModel.priceUsd + " $"
        item.marketCap.text = coinModel.market_cap_usd + " $"
        item.oneHourChange.text = coinModel.percent_change_1h + "%"
        item.twentyFourChange.text = coinModel.percent_change_24h + "%"
        item.sevenDayChange.text = coinModel.percent_change_7d + "%"




        item.oneHourChange.setTextColor(if (coinModel.percent_change_1h!!.contains("-"))
            Color.parseColor("#FF0000")
        else
            Color.parseColor("#32CD32")
        )

        item.twentyFourChange.setTextColor(if (coinModel.percent_change_24h!!.contains("-"))
            Color.parseColor("#FF0000")
        else
            Color.parseColor("#32CD32")
        )

        item.sevenDayChange.setTextColor(if (coinModel.percent_change_7d!!.contains("-"))
            Color.parseColor("#FF0000")
        else
            Color.parseColor("#32CD32")
        )


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_layout, parent, false)

        return CoinModelViewHolder(view)
    }
}