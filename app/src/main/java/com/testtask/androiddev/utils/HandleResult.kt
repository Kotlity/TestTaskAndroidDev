package com.testtask.androiddev.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend fun <T> handleResult(coroutineDispatcher: CoroutineDispatcher, resultBlock: suspend () -> T): T {
    return withContext(coroutineDispatcher) {
        resultBlock()
    }
}