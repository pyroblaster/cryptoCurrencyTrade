package com.reptil.panda.cryptocurrencytrading.database

import android.arch.persistence.room.Room
import com.reptil.panda.cryptocurrencytrading.App

object Database {

    private val database: UserDataBase by lazy { initDatabase() }

    private fun initDatabase(): UserDataBase {
        return Room.databaseBuilder(App.instance,
                UserDataBase::class.java, "user.db")
                .allowMainThreadQueries()
                .build()
    }

    fun getUserDao() = database.userDataDao()

    fun getCoinDao() = database.coinDataDao()
}