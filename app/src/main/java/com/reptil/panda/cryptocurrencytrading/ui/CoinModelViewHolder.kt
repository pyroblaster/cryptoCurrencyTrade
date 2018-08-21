package com.reptil.panda.cryptocurrencytrading.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import com.reptil.panda.cryptocurrencytrading.model.CoinModel
import kotlinx.android.synthetic.main.coin_layout.view.*

class CoinModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun showData(CoinModel: CoinModel) = with(itemView){
        //todo add some data
        coinName.text =CoinModel.name
        coinSymbol.text=CoinModel.symbol
        marketCap.text=CoinModel.market_cap
        oneHour.text=CoinModel.percent_change_1h
        twentyFourHour.text=CoinModel.percent_change_24h
        sevenDay.text=CoinModel.percent_change_7d

    }
}