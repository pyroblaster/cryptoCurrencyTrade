package com.reptil.panda.cryptocurrencytrading.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface UserDataDao {

    @Query("SELECT * from userData")
    fun getAll(): List<UserData>

    @Insert(onConflict = REPLACE)
    fun insert(userData: UserData)

    @Query("DELETE from userData")
    fun deleteAll()
}