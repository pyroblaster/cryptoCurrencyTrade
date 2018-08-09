package com.reptil.panda.cryptocurrencytrading.model

data class User(
        var id: String?,
        var currentFiatAmount: Double?,
        var currentCryptoCurrencyAmount: ArrayList<UserCoins>?
)