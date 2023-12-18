package com.exercise.summaryfive.data.network

import com.exercise.summaryfive.data.model.ApiResponse
import retrofit2.http.GET

interface ApiInterface {

    @GET("83160a49-fe85-46ba-bcf8-3cf5aa09f92b")
    suspend fun get(): ApiResponse

}