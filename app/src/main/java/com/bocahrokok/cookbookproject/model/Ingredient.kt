package com.bocahrokok.cookbookproject.model


import com.google.gson.annotations.SerializedName

data class Ingredient(
    val name: String,
    val quantity: String,
    val type: String
)