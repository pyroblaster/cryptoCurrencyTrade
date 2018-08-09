package com.reptil.panda.cryptocurrencytrading.model

class CoinModel {
    var id: String? = null
    var name: String? = null
    var symbol: String? = null
    var rank: String? = null
    var price: String? = null
    var volume_24h: String? = null
    var market_cap: String? = null
    var percent_change_1h: String? = null
    var percent_change_24h: String? = null
    var percent_change_7d: String? = null

    constructor(id: String, name: String, symbol: String, rank: String, price: String, volume_24h: String, market_cap: String, percent_change_1h: String,
                percent_change_24h: String, percent_change_7d: String) {
        this.id = id
        this.name = name
        this.symbol = symbol
        this.rank = rank
        this.price = price
        this.volume_24h = volume_24h
        this.market_cap = market_cap
        this.percent_change_1h = percent_change_1h
        this.percent_change_24h = percent_change_24h
        this.percent_change_7d = percent_change_7d
    }
}