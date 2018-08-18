package com.reptil.panda.cryptocurrencytrading.ui

interface CoinContract {

    interface View {

        fun onFailure()

        fun setCoinName(name: String?)

        fun setCoinSymbol(symbol: String?)

        fun setCoinPrice(price: String?)

        fun setCoinVolume24h(volume_24h: String?)

        fun setCoinMarketCap(market_cap: String?)

        fun setCoinPercentChange1h(percent_change_1h: String?)

        fun setCoinPercentChange24h(percent_change_24h: String?)

        fun setCoinPercentChange7d(percent_change_7d: String?)

    }

    interface Presenter {



    }
}