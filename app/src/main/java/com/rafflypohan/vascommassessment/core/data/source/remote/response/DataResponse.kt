package com.rafflypohan.vascommassessment.core.data.source.remote.response

import com.squareup.moshi.Json

data class DataResponse(

	@Json(name="per_page")
	val perPage: Int,

	@Json(name="total")
	val total: Int,

	@Json(name="data")
	val data: List<ResponseDataItem>,

	@Json(name="page")
	val page: Int,

	@Json(name="total_pages")
	val totalPages: Int,
)

data class ResponseDataItem(

	@Json(name="color")
	val color: String,

	@Json(name="year")
	val year: Int,

	@Json(name="name")
	val name: String,

	@Json(name="id")
	val id: Int,

	@Json(name="pantone_value")
	val pantoneValue: String
)
