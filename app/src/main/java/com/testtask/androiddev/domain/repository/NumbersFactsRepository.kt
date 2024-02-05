package com.testtask.androiddev.domain.repository

import com.testtask.androiddev.data.db.NumberFactEntity
import kotlinx.coroutines.flow.Flow

interface NumbersFactsRepository {

    suspend fun getInfoAboutSpecificNumber(number: Int): String
    suspend fun getMathInfoAboutRandomNumber(): String
    suspend fun insertNumberFactEntity(numberFactEntity: NumberFactEntity)
    fun retrieveNumbersFactsEntities(): Flow<List<NumberFactEntity>>
}