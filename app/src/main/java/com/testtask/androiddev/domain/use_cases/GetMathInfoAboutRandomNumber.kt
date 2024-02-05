package com.testtask.androiddev.domain.use_cases

import com.testtask.androiddev.domain.repository.NumbersFactsRepository
import javax.inject.Inject

class GetMathInfoAboutRandomNumber @Inject constructor(private val numbersFactsRepository: NumbersFactsRepository) {

    suspend operator fun invoke() = numbersFactsRepository.getMathInfoAboutRandomNumber()
}