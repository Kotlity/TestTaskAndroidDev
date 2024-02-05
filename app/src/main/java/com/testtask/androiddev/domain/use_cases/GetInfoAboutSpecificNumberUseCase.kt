package com.testtask.androiddev.domain.use_cases

import com.testtask.androiddev.domain.repository.NumbersFactsRepository
import javax.inject.Inject

class GetInfoAboutSpecificNumberUseCase @Inject constructor(private val numbersFactsRepository: NumbersFactsRepository) {

    suspend operator fun invoke(number: Int) = numbersFactsRepository.getInfoAboutSpecificNumber(number = number)
}