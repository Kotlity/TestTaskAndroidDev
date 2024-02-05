package com.testtask.androiddev.di.modules

import com.testtask.androiddev.data.db.NumbersFactsDao
import com.testtask.androiddev.data.repository_impl.NumbersFactsRepositoryImpl
import com.testtask.androiddev.data.rest_api.NumbersFactsApi
import com.testtask.androiddev.domain.dispatchers.Dispatchers
import com.testtask.androiddev.domain.repository.NumbersFactsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object NumbersFactsRepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideNumbersFactsRepository(
        numbersFactsApi: NumbersFactsApi,
        numbersFactsDao: NumbersFactsDao,
        dispatchers: Dispatchers
    ): NumbersFactsRepository = NumbersFactsRepositoryImpl(
        numbersFactsApi = numbersFactsApi,
        numbersFactsDao = numbersFactsDao,
        dispatchers = dispatchers,
    )

}