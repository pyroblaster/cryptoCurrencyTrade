package com.reptil.panda.cryptocurrencytrading.network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


object RetrofitUtil {

    private val retrofit by lazy { createRetrofit() }

    val apiService :ApiService by lazy { retrofit.create(ApiService::class.java) }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.COIN_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}