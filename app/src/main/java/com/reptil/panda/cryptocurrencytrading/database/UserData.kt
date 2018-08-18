package com.reptil.panda.cryptocurrencytrading.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "userData")
data class UserData(@PrimaryKey(autoGenerate = true) var id: String = "",
                    @ColumnInfo(name = "USD Amount") var currentFiatAmount: Double = 0.0)