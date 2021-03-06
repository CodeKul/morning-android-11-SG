package com.codekul.jsonparsing

import com.google.gson.annotations.SerializedName

data class ResultsItem(

	@field:SerializedName("nat")
	val nat: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("phone")
	val phone: String,

	@field:SerializedName("dob")
	val dob: String,

	@field:SerializedName("name")
	val name: Name,

	@field:SerializedName("registered")
	val registered: String,

	@field:SerializedName("location")
	val location: Location,

	@field:SerializedName("id")
	val id: Id,

	@field:SerializedName("login")
	val login: Login,

	@field:SerializedName("cell")
	val cell: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("picture")
	val picture: Picture
)