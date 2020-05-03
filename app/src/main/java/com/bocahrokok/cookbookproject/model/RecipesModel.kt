package com.bocahrokok.cookbookproject.model


import com.google.gson.annotations.SerializedName

data class RecipesModel(
    val imageURL: String,
    val ingredients: List<Ingredient>,
    val name: String,
    val originalURL: String,
    val steps: List<String>,
    val timers: List<Int>
)