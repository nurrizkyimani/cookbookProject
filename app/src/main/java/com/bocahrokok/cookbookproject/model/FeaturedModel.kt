package com.bocahrokok.cookbookproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "featured")
data class FeaturedModel(
    val pict:Int? ,
    @PrimaryKey
    val name: String)