package com.reptil.panda.cryptocurrencytrading

import android.app.Application
import android.content.Intent

//import com.reptil.panda.cryptocurrencytrading.ui.LoginActivity

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}