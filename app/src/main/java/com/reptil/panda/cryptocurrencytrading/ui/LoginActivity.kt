package com.reptil.panda.cryptocurrencytrading.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

import com.reptil.panda.cryptocurrencytrading.MainActivity
import com.reptil.panda.cryptocurrencytrading.database.Database
import com.reptil.panda.cryptocurrencytrading.database.UserData
import com.reptil.panda.cryptocurrencytrading.fragments.HomeFragment
import java.util.*

class LoginActivity : AppCompatActivity() {




    fun doStuff() {
        val userDao = Database.getUserDao()

        val users = userDao.getAll()

        if (users.isEmpty()) {
            userDao.insert(userData = UserData(UUID.randomUUID().toString(), 10000.0))
        }

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

}

