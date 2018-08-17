package com.reptil.panda.cryptocurrencytrading.network

import com.reptil.panda.cryptocurrencytrading.model.CoinModel
import io.reactivex.Flowable
import retrofit2.http.GET



interface ApiService {
    @GET("/v2/ticker/?start=0&limit=10")
    fun getCoinData(): Flowable<List<CoinModel>>
}