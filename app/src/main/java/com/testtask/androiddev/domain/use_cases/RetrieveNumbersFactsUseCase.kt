package com.testtask.androiddev.domain.use_cases

import com.testtask.androiddev.data.mapper.toNumberFact
import com.testtask.androiddev.domain.repository.NumbersFactsRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RetrieveNumbersFactsUseCase @Inject constructor(private val numbersFactsRepository: NumbersFactsRepository) {

    operator fun invoke() = numbersFactsRepository.retrieveNumbersFactsEntities()
        .map { numbersFactsEntities ->
            numbersFactsEntities.map { numberFactEntity ->
                numberFactEntity.toNumberFact()
            }
        }
}