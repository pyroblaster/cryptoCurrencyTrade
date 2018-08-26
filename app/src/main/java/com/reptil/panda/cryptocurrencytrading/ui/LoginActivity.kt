package com.reptil.panda.cryptocurrencytrading.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.reptil.panda.cryptocurrencytrading.MainActivity
import com.reptil.panda.cryptocurrencytrading.database.Database
import com.reptil.panda.cryptocurrencytrading.database.UserData
import java.util.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkUserState()
    }

    private fun checkUserState() {
        val userDao = Database.getUserDao()

        val users = userDao.getAll()

        val intent = Intent(this, MainActivity::class.java)

        if (users.isEmpty()) {
            userDao.insert(userData = UserData(currentFiatAmount = 10000.0))
            startActivity(intent)
        } else {
            startActivity(intent)
        }
    }
}

