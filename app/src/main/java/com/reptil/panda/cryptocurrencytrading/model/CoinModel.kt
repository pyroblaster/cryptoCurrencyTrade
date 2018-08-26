package com.reptil.panda.cryptocurrencytrading.model

import com.google.gson.annotations.SerializedName

class CoinModel {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("symbol")
    var symbol: String? = null
    @SerializedName("price_usd")
    var priceUsd: String? = null
    @SerializedName("24h_volume_usd")
    var volume_24h: String? = null
    @SerializedName("market_cap_usd")
    var market_cap_usd: String? = null
    @SerializedName("percent_change_1h")
    var percent_change_1h: String? = null
    @SerializedName("percent_change_24h")
    var percent_change_24h: String? = null
    @SerializedName("percent_change_7d")
    var percent_change_7d: String? = null

}
