package com.reptil.panda.cryptocurrencytrading.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [UserData::class, CoinPurchaseData::class], version = 1)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDataDao(): UserDataDao

    abstract fun coinDataDao(): CoinDataDao

    companion object {
        private var INSTANCE: UserDataBase? = null

        fun getInstance(context: Context): UserDataBase? {
            if (INSTANCE == null) {
                synchronized(UserDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            UserDataBase::class.java, "user.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}