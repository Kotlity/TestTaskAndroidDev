package com.testtask.androiddev.data.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["numberFact"], unique = true)])
data class NumberFactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val numberFact: String
)