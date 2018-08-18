package com.reptil.panda.cryptocurrencytrading.model

data class CoinModel(
        var id: String?,
        var name: String?,
        var symbol: String?,
        var rank: String?,
        var price: Double?,
        var volume_24h: String?,
        var market_cap: String?,
        var percent_change_1h: String?,
        var percent_change_24h: String?,
        var percent_change_7d: String?
)