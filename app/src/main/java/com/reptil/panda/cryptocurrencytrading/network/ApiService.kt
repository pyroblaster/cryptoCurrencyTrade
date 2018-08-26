package com.reptil.panda.cryptocurrencytrading.network

import com.reptil.panda.cryptocurrencytrading.model.CoinModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("/v1/ticker/?start=0&limit=10")
    fun getCoinData(): Flowable<List<CoinModel>>

    @GET("/v1/ticker/{id}")
    fun getCoin(@Path("id") coinId: String): Flowable<List<CoinModel>>
}