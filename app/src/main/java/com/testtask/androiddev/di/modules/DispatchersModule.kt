package com.testtask.androiddev.di.modules

import com.testtask.androiddev.domain.dispatchers.Dispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @Singleton
    fun provideDispatchers() = Dispatchers(
        main = kotlinx.coroutines.Dispatchers.Main,
        io = kotlinx.coroutines.Dispatchers.IO,
        default = kotlinx.coroutines.Dispatchers.Default,
        unconfined = kotlinx.coroutines.Dispatchers.Unconfined
    )
}