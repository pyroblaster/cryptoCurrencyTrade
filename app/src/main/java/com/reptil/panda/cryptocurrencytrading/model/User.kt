package com.reptil.panda.cryptocurrencytrading.model

import java.util.*

class User {
    var id: String? = null
    var currentFiatAmount: Double? = null
    var currentCryptoCurrencyAmount: ArrayList<UserCoins>? = null

    constructor(currentFiatAmount: Double, currentCryptoCurrencyAmount: ArrayList<UserCoins>) {
        this.id = UUID.randomUUID().toString()

        this.currentFiatAmount = currentFiatAmount
        this.currentCryptoCurrencyAmount = currentCryptoCurrencyAmount

    }

}