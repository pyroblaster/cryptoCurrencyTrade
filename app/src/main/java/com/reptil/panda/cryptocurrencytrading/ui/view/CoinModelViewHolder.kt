package com.reptil.panda.cryptocurrencytrading.ui.view


import android.app.Activity
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reptil.panda.cryptocurrencytrading.R
import com.reptil.panda.cryptocurrencytrading.model.CoinModel
import kotlinx.android.synthetic.main.coin_layout.view.*

class CoinModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //todo add some data
    var coinSymbol = itemView.coinSymbol
    var coinName = itemView.coinName
    var coinPrice = itemView.priceUsd
    var oneHourChange = itemView.oneHour
    var twentyFourChange = itemView.twentyFourHour
    var sevenDayChange = itemView.sevenDay
    var marketCap = itemView.marketCap
    //volume24h mozda

    private lateinit var coinModel: CoinModel
    private lateinit var activity: Activity

    fun setCoinModel(coinModel: CoinModel) {
        this.coinModel = coinModel
        setItem()
    }
    fun setActivity(activity: Activity){
        this.activity = activity
    }


    fun setItem() {

        coinName.text = coinModel.name
        coinSymbol.text = coinModel.symbol
        coinPrice.text = coinModel.priceUsd
        marketCap.text = coinModel.market_cap_usd
        oneHourChange.text = coinModel.percent_change_1h + "%"
        twentyFourChange.text = coinModel.percent_change_24h + "%"
        sevenDayChange.text = coinModel.percent_change_7d + "%"

        oneHourChange.setTextColor(if (coinModel.percent_change_1h!!.contains("-"))
            Color.parseColor("#FF0000")
        else
            Color.parseColor("#32CD32")
        )

        twentyFourChange.setTextColor(if (coinModel.percent_change_24h!!.contains("-"))
            Color.parseColor("#FF0000")
        else
            Color.parseColor("#32CD32")
        )

        //STAVI VRIJEDOST 2 AKO JE NULL CAO


        sevenDayChange.setTextColor(if (coinModel.percent_change_7d!!.contains("-"))
            Color.parseColor("#FF0000")
        else
            Color.parseColor("#32CD32")
        )

    }


}