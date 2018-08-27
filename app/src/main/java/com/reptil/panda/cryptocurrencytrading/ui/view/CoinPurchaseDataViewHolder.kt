package com.reptil.panda.cryptocurrencytrading.ui.view

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import com.reptil.panda.cryptocurrencytrading.database.CoinPurchaseData
import com.reptil.panda.cryptocurrencytrading.model.CoinModel

import kotlinx.android.synthetic.main.user_coin_layout.view.*

class CoinPurchaseDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //todo add some data

    var coinName = itemView.coinName
    var coinSymbol = itemView.coinSymbol
    var coinAmount = itemView.amount
    var worth = itemView.worth
    var timestamp = itemView.timestamp

    private lateinit var coinPurchaseData: CoinPurchaseData
    private lateinit var activity: Activity

    fun setCoinPurchaseData(coinPurchaseData: CoinPurchaseData) {
        this.coinPurchaseData = coinPurchaseData
        setItem()
    }

    fun setActivity(activity: Activity) {
        this.activity = activity
    }


    fun setItem() {

        coinName.text = coinPurchaseData.coinName
        coinSymbol.text = coinPurchaseData.coinId
        worth.text = coinPurchaseData.currentPrice.toString()
        coinAmount.text = coinPurchaseData.amount.toString()
        timestamp.text = coinPurchaseData.timestamp.toString()


    }
}