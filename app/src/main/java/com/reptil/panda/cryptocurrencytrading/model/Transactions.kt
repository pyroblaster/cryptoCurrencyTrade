package com.reptil.panda.cryptocurrencytrading.model

import java.util.*


class Transactions {
    var transactionId: String? = null
    var coinId: String? = null
    var amountUsd: Double? = null
    var amountCryptoCurrency: Double? = null
    var transactionTimestamp: String? = null

    constructor(coinId: String, amountUsd: Double, amountCryptoCurrency: Double, transactionTimestamp: String) {
        this.transactionId = UUID.randomUUID().toString()
        this.coinId = coinId
        this.amountUsd = amountUsd
        this.amountCryptoCurrency = amountCryptoCurrency
        this.transactionTimestamp = transactionTimestamp
    }


}