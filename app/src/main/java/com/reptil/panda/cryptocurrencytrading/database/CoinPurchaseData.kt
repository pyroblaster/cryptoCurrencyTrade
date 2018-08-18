package com.reptil.panda.cryptocurrencytrading.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "coinData")
data class CoinPurchaseData(@PrimaryKey(autoGenerate = true) var id: Long? = null,
                            var coinId: String? = null,
                            var userId: String? = null,
                            @ColumnInfo(name = "USD price") var currentPrice: Double = 0.0,
                            @ColumnInfo(name = "Amount") var amount: Double = 0.0,
                            var timestamp: Long = 0)

