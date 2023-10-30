package com.rafflypohan.vascommassessment.core.data.mappers

import com.rafflypohan.vascommassessment.core.data.source.remote.response.LoginResponse
import com.rafflypohan.vascommassessment.core.data.source.remote.response.ResponseDataItem
import com.rafflypohan.vascommassessment.core.domain.model.LoginModel
import com.rafflypohan.vascommassessment.core.domain.model.ModelDataItem

fun List<ResponseDataItem>.toDomain() = this.map {
    ModelDataItem(
        color = it.color,
        name = it.name,
        year = it.year,
        id = it.id,
        pantoneValue = it.pantoneValue
    )
}

fun LoginResponse.toDomain() =
    LoginModel(
        token = token
    )