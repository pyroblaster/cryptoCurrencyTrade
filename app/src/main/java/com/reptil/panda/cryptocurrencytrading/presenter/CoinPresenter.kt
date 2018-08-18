package com.reptil.panda.cryptocurrencytrading.presenter


import com.reptil.panda.cryptocurrencytrading.interactor.ApiInteractor
import com.reptil.panda.cryptocurrencytrading.network.RetrofitUtil
import com.reptil.panda.cryptocurrencytrading.ui.CoinContract


class CoinPresenter(private val apiInteractor: ApiInteractor) : CoinContract.Presenter {

    private var coinView: CoinContract.View? = null


    fun doStuff() {
    }
}