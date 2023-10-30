package com.rafflypohan.vascommassessment.core.domain.repository

import com.rafflypohan.vascommassessment.core.data.source.remote.api.ApiResponse
import com.rafflypohan.vascommassessment.core.domain.model.DataModel
import com.rafflypohan.vascommassessment.core.domain.model.ModelDataItem
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    fun getData(): Flow<ApiResponse<List<ModelDataItem>>>
}