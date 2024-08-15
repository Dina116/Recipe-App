package com.training.recipeapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteRecipeDao {
    @Insert
    fun insertRecipe(recipe: FavoriteRecipe)

    @Query("SELECT * FROM favorite_recipes")
    fun getAllFavorites(): LiveData<List<FavoriteRecipe>>

    @Delete
   suspend fun delete(recipe: FavoriteRecipe)

}