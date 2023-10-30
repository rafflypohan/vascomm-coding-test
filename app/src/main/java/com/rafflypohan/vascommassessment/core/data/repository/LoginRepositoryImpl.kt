package com.rafflypohan.vascommassessment.core.data.repository

import com.rafflypohan.vascommassessment.core.data.mappers.toDomain
import com.rafflypohan.vascommassessment.core.data.source.remote.api.ApiResponse
import com.rafflypohan.vascommassessment.core.data.source.remote.api.ApiService
import com.rafflypohan.vascommassessment.core.data.source.remote.request.LoginRequest
import com.rafflypohan.vascommassessment.core.domain.model.LoginModel
import com.rafflypohan.vascommassessment.core.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): LoginRepository {
    override fun login(loginRequest: LoginRequest): Flow<ApiResponse<LoginModel>> = flow {
        try {
            val response = apiService.login(loginRequest)

            if (response.token != null){
                emit(ApiResponse.Success(response.toDomain()))
            } else {
                emit(ApiResponse.Error("Missing password"))
            }
        } catch (e: HttpException){
            emit(ApiResponse.Error(e.message()))
        }
    }
}