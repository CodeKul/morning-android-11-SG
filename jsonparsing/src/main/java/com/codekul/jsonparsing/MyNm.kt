package com.codekul.jsonparsing

import com.google.gson.annotations.SerializedName

data class MyNm(

	@field:SerializedName("results")
	val results: List<ResultsItem>,

	@field:SerializedName("info")
	val info: Info
)