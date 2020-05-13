package com.bocahrokok.cookbookproject.repository

import androidx.lifecycle.LiveData
import com.bocahrokok.cookbookproject.R
import com.bocahrokok.cookbookproject.database.HomeDatabase
import com.bocahrokok.cookbookproject.model.FeaturedModel
import com.bocahrokok.cookbookproject.model.GridModel
import com.bocahrokok.cookbookproject.model.Ingredient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CookbookRepository(val db: HomeDatabase) {

    val data : LiveData<List<FeaturedModel>> = db.getHomeDao().getAll()
    val ingredientData: LiveData<List<Ingredient>> = db.getHomeDao().getIngredient()


    suspend fun fetchDataInsertRoom() {
        withContext(Dispatchers.IO){


            var featuredItems: ArrayList<FeaturedModel> = ArrayList()

            featuredItems.add(
                FeaturedModel(
                    R.drawable.food_1,
                    "Frech Omellete"
                )
            )

            featuredItems.add(
                FeaturedModel(
                    R.drawable.food_2,
                    "Riccotta Gnocc"
                )
            )
            featuredItems.add(
                FeaturedModel(
                    R.drawable.food_3,
                    "Shimp Soup"
                )
            )
//            val list :  List<FeaturedModel>
//            list = List(2)
            db.getHomeDao().insertAll(featuredItems)
            var gridList: ArrayList<Ingredient> = ArrayList()
            db.getHomeDao().insertIngredient(gridList)

        }
    }

}