package com.reptil.panda.cryptocurrencytrading.database

Entity(tableName = "userData")
data class UserData(@PrimaryKey(autoGenerate = true) var id: Long?,
                       @ColumnInfo(name = "USD Amount") var currentFiatAmount: Int,
                       @ColumnInfo(name = "Cryptocurrency Amount") var currentCryptoCurrencyAmount: Double //to bi trebalo vjerovatno array napravit?


){
    constructor():this(null,0,0.0)
}