package com.training.recipeapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository = UserRepository(
        AppDatabase.getDatabase(application).userDao(),
        AppDatabase.getDatabase(application).favoriteRecipeDao()
    )



    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertUser(user)
    }

    suspend fun getUser(email: String): User? {
        return repository.getUserByEmail(email)
    }

    suspend fun insertRecipe(recipe: FavoriteRecipe)= withContext(Dispatchers.IO){
        repository.insertRecipe(recipe)
    }

    fun getFavoriteRecipes(): LiveData<List<FavoriteRecipe>> =repository.getAllFavorites()

    suspend fun deleteRecipe(recipe: FavoriteRecipe) = withContext(Dispatchers.IO){
        repository.deleteRecipe(recipe) }


    // Add this function to clear all users from the database
    fun clearAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        repository.clearAllUsers()
    }
}
