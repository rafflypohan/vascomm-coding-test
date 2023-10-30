package com.rafflypohan.vascommassessment.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModel(
	val perPage: Int? = null,
	val total: Int? = null,
	val data: List<ModelDataItem?>? = null,
	val page: Int? = null,
	val totalPages: Int? = null,
): Parcelable

@Parcelize
data class ModelDataItem(
	val color: String? = null,
	val year: Int? = null,
	val name: String? = null,
	val id: Int? = null,
	val pantoneValue: String? = null
): Parcelable

