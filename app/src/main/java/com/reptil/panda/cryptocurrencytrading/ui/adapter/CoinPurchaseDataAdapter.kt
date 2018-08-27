package com.reptil.panda.cryptocurrencytrading.ui.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.reptil.panda.cryptocurrencytrading.R
import com.reptil.panda.cryptocurrencytrading.database.CoinPurchaseData
import com.reptil.panda.cryptocurrencytrading.ui.view.CoinPurchaseDataViewHolder

class CoinPurchaseDataAdapter : RecyclerView.Adapter<CoinPurchaseDataViewHolder>() {

private val items = ArrayList<CoinPurchaseData>()

fun setData(newItems: List<CoinPurchaseData>) {
    items.clear()
    items.addAll(newItems)
    notifyDataSetChanged()
}

override fun getItemCount(): Int {
    return items.size
}

override fun onBindViewHolder(holder: CoinPurchaseDataViewHolder, position: Int) {
    val coinPurchaseData = items.get(position)

    val item = holder as CoinPurchaseDataViewHolder

    item.coinName.text = coinPurchaseData.coinName
    item.coinAmount.text = coinPurchaseData.amount.toString()
    item.timestamp.text = coinPurchaseData.timestamp.toString()
    item.worth.text = coinPurchaseData.currentPrice.toString()
}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinPurchaseDataViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.user_coin_layout, parent, false)

    return CoinPurchaseDataViewHolder(view)
}
}