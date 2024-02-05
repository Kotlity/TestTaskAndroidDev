package com.testtask.androiddev.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NumbersFactsDao {

    @Insert
    suspend fun insertNumberFactEntity(numberFactEntity: NumberFactEntity)

    @Query("SELECT * FROM numberfactentity")
    fun retrieveNumbersFactsEntities(): Flow<List<NumberFactEntity>>
}