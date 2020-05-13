package com.bocahrokok.cookbookproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bocahrokok.cookbookproject.model.FeaturedModel
import com.bocahrokok.cookbookproject.model.Ingredient

@Database(entities = [FeaturedModel::class, Ingredient::class], version = 1)
abstract class HomeDatabase : RoomDatabase(){

    abstract fun getHomeDao(): HomeDao

    companion object{
        @Volatile
        private var instance: HomeDatabase? = null
        private val LOCK = Any()

        operator  fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance?: createDatabase(context).also{ instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                HomeDatabase::class.java,
                "home.db"
            ).build()
    }
}