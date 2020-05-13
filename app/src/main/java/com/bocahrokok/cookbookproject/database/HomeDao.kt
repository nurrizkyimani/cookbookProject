package com.bocahrokok.cookbookproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bocahrokok.cookbookproject.model.FeaturedModel
import com.bocahrokok.cookbookproject.model.GridModel
import com.bocahrokok.cookbookproject.model.Ingredient

@Dao
interface HomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(listFeatured: List<FeaturedModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIngredient(listIngre: List<Ingredient>)

    @Query("select * from featured ")
    fun getAll(): LiveData<List<FeaturedModel>>

    @Query("select * from ingredient")
    fun getIngredient(): LiveData<List<Ingredient>>
}