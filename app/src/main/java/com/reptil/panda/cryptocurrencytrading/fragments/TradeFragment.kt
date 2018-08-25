package com.reptil.panda.cryptocurrencytrading.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reptil.panda.cryptocurrencytrading.R
import com.reptil.panda.cryptocurrencytrading.database.CoinPurchaseData
import com.reptil.panda.cryptocurrencytrading.database.Database
import com.reptil.panda.cryptocurrencytrading.model.CoinModel

class TradeFragment : Fragment() {

    private val coinDataDao by lazy { Database.getCoinDao() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    private fun buyCoin(coinModel: CoinModel) {
        val newPurchase = CoinPurchaseData(coinId = coinModel.id,
                userId = "trenutni user",
                amount = 505.0, //read this from an input field
                currentPrice = coinModel.priceUsd?.toDouble() ?: 0.0,
                timestamp = System.currentTimeMillis()
        )

        coinDataDao.storePurchase(newPurchase)
    }

    fun showAllPurchases() {
        val coinsForUser = coinDataDao.getCoinsForUser("trenutni user")//todo change this to an actual id
    }


    companion object {
        fun newInstance(): TradeFragment = TradeFragment()

    }
}