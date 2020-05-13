package com.bocahrokok.cookbookproject.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ingredient")
data class Ingredient(
    @PrimaryKey
    val name: String,
    val quantity: String,
    val type: String
)