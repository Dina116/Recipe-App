package com.training.recipeapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository = UserRepository(
        AppDatabase.getDatabase(application).userDao(),
        AppDatabase.getDatabase(application).favoriteRecipeDao()
    )

    //val allUsers: Flow<List<User>> = repository.getAllUsers()

    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }

    suspend fun getUser(email: String): User? {
        return repository.getUserByEmail(email)
    }

    suspend fun insertRecipe(recipe: FavoriteRecipe){
       repository.insertRecipe(recipe)
    }

    fun getFavoriteRecipes(): Flow<List<FavoriteRecipe>> =repository.getAllFavorites()

    suspend fun deleteRecipe(recipe: FavoriteRecipe) = run { repository.deleteRecipe(recipe) }



}
