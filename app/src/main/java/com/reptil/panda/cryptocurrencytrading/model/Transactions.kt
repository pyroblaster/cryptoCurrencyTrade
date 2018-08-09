package com.reptil.panda.cryptocurrencytrading.model

import java.util.*


data class Transactions(
        var transactionId: String?,
        var coinId: String?,
        var amountUsd: Double?,
        var amountCryptoCurrency: Double?,
        var transactionTimestamp: String?
)