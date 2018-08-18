package com.reptil.panda.cryptocurrencytrading.network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class RetrofitUtil {

    fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.COIN_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}