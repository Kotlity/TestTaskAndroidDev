package com.testtask.androiddev.data.rest_api

import com.testtask.androiddev.utils.Constants.MATH_TYPE
import com.testtask.androiddev.utils.Constants.NUMBER_PATH
import com.testtask.androiddev.utils.Constants.RANDOM
import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersFactsApi {

    @GET("{$NUMBER_PATH}")
    suspend fun getInfoAboutSpecificNumber(@Path(NUMBER_PATH) number: Int): String

    @GET("$RANDOM/$MATH_TYPE")
    suspend fun getMathInfoAboutRandomNumber(): String
}