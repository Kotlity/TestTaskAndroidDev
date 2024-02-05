package com.testtask.androiddev.domain.use_cases

import com.testtask.androiddev.data.mapper.toNumberFactEntity
import com.testtask.androiddev.domain.model.NumberFact
import com.testtask.androiddev.domain.repository.NumbersFactsRepository
import javax.inject.Inject

class InsertNumberFactUseCase @Inject constructor(private val numbersFactsRepository: NumbersFactsRepository) {

    suspend operator fun invoke(numberFact: NumberFact) {
        numbersFactsRepository.insertNumberFactEntity(numberFactEntity = numberFact.toNumberFactEntity())
    }
}