package com.rafflypohan.vascommassessment.core.domain.repository

import com.rafflypohan.vascommassessment.core.data.source.remote.api.ApiResponse
import com.rafflypohan.vascommassessment.core.data.source.remote.request.LoginRequest
import com.rafflypohan.vascommassessment.core.domain.model.LoginModel
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(loginRequest: LoginRequest): Flow<ApiResponse<LoginModel>>
}