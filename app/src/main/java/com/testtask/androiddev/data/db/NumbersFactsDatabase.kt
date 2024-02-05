package com.testtask.androiddev.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NumberFactEntity::class], version = 1)
abstract class NumbersFactsDatabase: RoomDatabase() {

    abstract val numbersFactsDao: NumbersFactsDao
}