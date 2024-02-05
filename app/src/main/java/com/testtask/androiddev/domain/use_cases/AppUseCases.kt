package com.testtask.androiddev.domain.use_cases

data class AppUseCases(
    val getInfoAboutSpecificNumberUseCase: GetInfoAboutSpecificNumberUseCase,
    val getMathInfoAboutRandomNumber: GetMathInfoAboutRandomNumber,
    val insertNumberFactUseCase: InsertNumberFactUseCase,
    val retrieveNumbersFactsUseCase: RetrieveNumbersFactsUseCase
)
