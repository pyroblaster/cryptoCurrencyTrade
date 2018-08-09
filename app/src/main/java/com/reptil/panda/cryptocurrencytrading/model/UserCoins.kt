package com.reptil.panda.cryptocurrencytrading.model

data class UserCoins(val coinId: String, var coinAmount: Double) {
    fun addCoinsToUser(coinAmount: Double) {
        this.coinAmount += coinAmount
    }

    fun substractCoinsFromUser(coinAmount: Double) {
        this.coinAmount -= coinAmount

    }
}


