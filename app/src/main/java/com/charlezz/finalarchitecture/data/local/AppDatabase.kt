package com.charlezz.finalarchitecture.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.charlezz.finalarchitecture.data.local.dao.CardDao
import com.charlezz.finalarchitecture.data.local.entity.Card

@Database(entities = [(Card::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
}