package com.rafflypohan.vascommassessment.core.data.source.remote.response

import com.squareup.moshi.Json

data class LoginResponse(
    @Json(name = "token")
    val token: String? = null
)
