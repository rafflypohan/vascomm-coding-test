package com.rafflypohan.vascommassessment.core.domain.usecase

import com.rafflypohan.vascommassessment.core.data.source.remote.api.ApiResponse
import com.rafflypohan.vascommassessment.core.domain.model.ModelDataItem
import com.rafflypohan.vascommassessment.core.domain.repository.DataRepository
import com.rafflypohan.vascommassessment.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {
    operator fun invoke(): Flow<Resource<List<ModelDataItem>>> = flow {
        dataRepository.getData().collect {
            when(it){
                is ApiResponse.Success -> emit(Resource.Success(it.data))
                is ApiResponse.Error -> emit(Resource.Error(it.errorMessage))
                is ApiResponse.Empty -> emit(Resource.Error(it.errorMessage))
            }
        }
    }
}