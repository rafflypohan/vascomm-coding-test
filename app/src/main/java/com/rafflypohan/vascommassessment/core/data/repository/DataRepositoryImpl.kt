package com.rafflypohan.vascommassessment.core.data.repository

import com.rafflypohan.vascommassessment.core.data.mappers.toDomain
import com.rafflypohan.vascommassessment.core.data.source.remote.api.ApiResponse
import com.rafflypohan.vascommassessment.core.data.source.remote.api.ApiService
import com.rafflypohan.vascommassessment.core.domain.model.DataModel
import com.rafflypohan.vascommassessment.core.domain.model.ModelDataItem
import com.rafflypohan.vascommassessment.core.domain.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): DataRepository {
    override fun getData(): Flow<ApiResponse<List<ModelDataItem>>> = flow {
        try {
            val response = apiService.getData()

            if (response.data.isNotEmpty()){
                emit(ApiResponse.Success(response.data.toDomain()))
            } else {
                emit(ApiResponse.Error("Data is Empty"))
            }
        } catch (e: HttpException){
            emit(ApiResponse.Error(e.message()))
        }
    }

}