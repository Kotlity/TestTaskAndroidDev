package com.testtask.androiddev.di.modules

import android.content.Context
import androidx.room.Room
import com.testtask.androiddev.data.db.NumbersFactsDatabase
import com.testtask.androiddev.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNumbersFactsDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context,
        klass = NumbersFactsDatabase::class.java,
        name = DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideNumbersFactsDao(numbersFactsDatabase: NumbersFactsDatabase) = numbersFactsDatabase.numbersFactsDao

}