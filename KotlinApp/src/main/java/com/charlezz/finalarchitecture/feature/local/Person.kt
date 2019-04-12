package com.charlezz.finalarchitecture.feature.local

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "person")
data class Person
constructor(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val name: String,
        val birth: String
)