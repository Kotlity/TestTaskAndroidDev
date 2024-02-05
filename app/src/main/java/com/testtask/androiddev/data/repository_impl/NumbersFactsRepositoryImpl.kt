package com.testtask.androiddev.data.repository_impl

import com.testtask.androiddev.data.db.NumberFactEntity
import com.testtask.androiddev.data.db.NumbersFactsDao
import com.testtask.androiddev.data.rest_api.NumbersFactsApi
import com.testtask.androiddev.domain.dispatchers.Dispatchers
import com.testtask.androiddev.domain.repository.NumbersFactsRepository
import com.testtask.androiddev.utils.handleResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NumbersFactsRepositoryImpl @Inject constructor(
    private val numbersFactsApi: NumbersFactsApi,
    private val numbersFactsDao: NumbersFactsDao,
    private val dispatchers: Dispatchers
): NumbersFactsRepository {

    override suspend fun getInfoAboutSpecificNumber(number: Int): String {
        return handleResult(dispatchers.io) {
            numbersFactsApi.getInfoAboutSpecificNumber(number = number)
        }
    }

    override suspend fun getMathInfoAboutRandomNumber(): String {
        return handleResult(dispatchers.io) {
            numbersFactsApi.getMathInfoAboutRandomNumber()
        }
    }

    override suspend fun insertNumberFactEntity(numberFactEntity: NumberFactEntity) {
        return handleResult(dispatchers.io) {
            numbersFactsDao.insertNumberFactEntity(numberFactEntity = numberFactEntity)
        }
    }

    override fun retrieveNumbersFactsEntities(): Flow<List<NumberFactEntity>> {
        return numbersFactsDao
            .retrieveNumbersFactsEntities()
            .flowOn(dispatchers.io)
    }
}