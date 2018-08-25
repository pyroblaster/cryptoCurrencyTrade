package com.reptil.panda.cryptocurrencytrading.model

import com.google.gson.annotations.SerializedName

class CoinModel {

    @SerializedName("id")
    val id: String? = null
    @SerializedName("name")
    val name: String? = null
    @SerializedName("symbol")
    val symbol: String? = null
    @SerializedName("price_usd")
    val priceUsd: String? = null
    @SerializedName("24h_volume_usd")
    val volume_24h: String? = null
    @SerializedName("market_cap_usd")
    val market_cap_usd: String? = null
    @SerializedName("percent_change_1h")
    val percent_change_1h: String? = null
    @SerializedName("percent_change_24h")
    val percent_change_24h: String? = null
    @SerializedName("percent_change_7d")
    val percent_change_7d: String? = null

}
