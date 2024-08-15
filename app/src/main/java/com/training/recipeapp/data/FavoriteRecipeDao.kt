package com.training.recipeapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteRecipeDao {
    @Insert
    fun insertRecipe(recipe: FavoriteRecipe)

    @Query("SELECT * FROM favorite_recipes")
    fun getAllFavorites(): LiveData<List<FavoriteRecipe>>

    @Delete
   fun delete(recipe: FavoriteRecipe)

}