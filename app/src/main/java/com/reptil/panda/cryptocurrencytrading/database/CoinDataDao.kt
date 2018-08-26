package com.reptil.panda.cryptocurrencytrading.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface CoinDataDao {

    @Query("SELECT * from coinData where userId = :userId")
    fun getCoinsForUser(userId: Long): List<CoinPurchaseData>

    @Query("SELECT * from coinData")
    fun getAll(): List<CoinPurchaseData>

    @Insert(onConflict = REPLACE)
    fun storePurchase(coinPurchaseData: CoinPurchaseData)

    @Delete
    fun deletePurchase(coinPurchaseData: CoinPurchaseData)
}