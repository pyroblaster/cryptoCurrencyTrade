package com.reptil.panda.cryptocurrencytrading.interactor

import com.reptil.panda.cryptocurrencytrading.model.CoinModel
import retrofit2.Callback;

interface ApiInteractor {

    fun getCoins(callback: Callback<CoinModel>, id: String)

}