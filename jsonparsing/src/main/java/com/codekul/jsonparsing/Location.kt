package com.codekul.jsonparsing

import com.google.gson.annotations.SerializedName

data class Location(

	@field:SerializedName("city")
	val city: String,

	@field:SerializedName("street")
	val street: String,

	@field:SerializedName("postcode")
	val postcode: Int,

	@field:SerializedName("state")
	val state: String
)