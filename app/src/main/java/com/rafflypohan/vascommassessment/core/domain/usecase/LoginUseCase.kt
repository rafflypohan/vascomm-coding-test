package com.rafflypohan.vascommassessment.core.domain.usecase

import com.rafflypohan.vascommassessment.core.data.source.remote.api.ApiResponse
import com.rafflypohan.vascommassessment.core.data.source.remote.request.LoginRequest
import com.rafflypohan.vascommassessment.core.domain.model.LoginModel
import com.rafflypohan.vascommassessment.core.domain.repository.LoginRepository
import com.rafflypohan.vascommassessment.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(loginRequest: LoginRequest): Flow<Resource<LoginModel>> = flow {
        loginRepository.login(loginRequest).collect {
            when(it){
                is ApiResponse.Success -> emit(Resource.Success(it.data))
                is ApiResponse.Error -> emit(Resource.Error(it.errorMessage))
                is ApiResponse.Empty -> emit(Resource.Error(it.errorMessage))
            }
        }
    }
}