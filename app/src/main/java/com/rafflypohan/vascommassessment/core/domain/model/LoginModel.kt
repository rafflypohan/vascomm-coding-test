package com.rafflypohan.vascommassessment.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginModel(
    val token: String? = null
): Parcelable
