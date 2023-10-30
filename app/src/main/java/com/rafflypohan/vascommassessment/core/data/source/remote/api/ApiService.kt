package com.rafflypohan.vascommassessment.core.data.source.remote.api

import com.rafflypohan.vascommassessment.core.data.source.remote.request.LoginRequest
import com.rafflypohan.vascommassessment.core.data.source.remote.response.DataResponse
import com.rafflypohan.vascommassessment.core.data.source.remote.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("login")
    suspend fun getData(): DataResponse

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}