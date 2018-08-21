package com.reptil.panda.cryptocurrencytrading.ui

import android.support.v7.app.AppCompatActivity
import com.reptil.panda.cryptocurrencytrading.database.Database
import com.reptil.panda.cryptocurrencytrading.database.UserData
import java.util.*

class LoginActivity : AppCompatActivity() {


    fun doStuff() {
        val userDao = Database.getUserDao()

        val users = userDao.getAll()

        if (users.isEmpty()) {
            userDao.insert(userData = UserData(UUID.randomUUID().toString(), 10000.0))

        }        //IDI NA MAIN
    }
}