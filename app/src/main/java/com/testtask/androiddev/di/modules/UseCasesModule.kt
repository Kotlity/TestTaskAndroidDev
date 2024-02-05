package com.testtask.androiddev.di.modules

import com.testtask.androiddev.domain.repository.NumbersFactsRepository
import com.testtask.androiddev.domain.use_cases.AppUseCases
import com.testtask.androiddev.domain.use_cases.GetInfoAboutSpecificNumberUseCase
import com.testtask.androiddev.domain.use_cases.GetMathInfoAboutRandomNumber
import com.testtask.androiddev.domain.use_cases.InsertNumberFactUseCase
import com.testtask.androiddev.domain.use_cases.RetrieveNumbersFactsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {

    @Provides
    @ViewModelScoped
    fun provideGetInfoAboutSpecificNumberUseCase(
        numbersFactsRepository: NumbersFactsRepository
    ) = GetInfoAboutSpecificNumberUseCase(
        numbersFactsRepository = numbersFactsRepository
    )

    @Provides
    @ViewModelScoped
    fun provideGetMathInfoAboutRandomNumberUseCase(
        numbersFactsRepository: NumbersFactsRepository
    ) = GetMathInfoAboutRandomNumber(
        numbersFactsRepository = numbersFactsRepository
    )

    @Provides
    @ViewModelScoped
    fun provideInsertNumberFactUseCase(
        numbersFactsRepository: NumbersFactsRepository
    ) = InsertNumberFactUseCase(
        numbersFactsRepository = numbersFactsRepository
    )

    @Provides
    @ViewModelScoped
    fun provideRetrieveNumbersFactsUseCase(
        numbersFactsRepository: NumbersFactsRepository
    ) = RetrieveNumbersFactsUseCase(
        numbersFactsRepository = numbersFactsRepository
    )

    @Provides
    @ViewModelScoped
    fun provideAppUseCases(
        getInfoAboutSpecificNumberUseCase: GetInfoAboutSpecificNumberUseCase,
        getMathInfoAboutRandomNumber: GetMathInfoAboutRandomNumber,
        insertNumberFactUseCase: InsertNumberFactUseCase,
        retrieveNumbersFactsUseCase: RetrieveNumbersFactsUseCase
    ) = AppUseCases(
        getInfoAboutSpecificNumberUseCase = getInfoAboutSpecificNumberUseCase,
        getMathInfoAboutRandomNumber = getMathInfoAboutRandomNumber,
        insertNumberFactUseCase = insertNumberFactUseCase,
        retrieveNumbersFactsUseCase = retrieveNumbersFactsUseCase
    )

}