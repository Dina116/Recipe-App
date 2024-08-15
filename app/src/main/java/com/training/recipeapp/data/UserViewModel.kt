package com.training.recipeapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository = UserRepository(
        AppDatabase.getDatabase(application).userDao(),
        AppDatabase.getDatabase(application).favoriteRecipeDao()
    )

    val allUsers: LiveData<List<User>> = repository.allUsers

    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }

    suspend fun getUser(email: String): LiveData<User> {
        return repository.getUserByEmail(email)
    }

    fun insertRecipe(recipe: FavoriteRecipe) = viewModelScope.launch {
        repository.insertRecipe(recipe)
    }

    fun getFavoriteRecipes(): LiveData<List<FavoriteRecipe>> {
        return repository.getAllFavorites()
    }

    fun deleteRecipe(recipe: FavoriteRecipe) = viewModelScope.launch {
        repository.deleteRecipe(recipe)
    }



}
//    private val userDao = AppDatabase.getDatabase(application).userDao()
//    private val recipeDao = AppDatabase.getDatabase(application).favoriteRecipeDao()
//
//    fun insertUser(user: User) {
//        viewModelScope.launch {
//            userDao.insert(user)
//        }
//    }
//
//    fun getUser(email: String) {
//        viewModelScope.launch {
//            val user = userDao.getUserByEmail(email)
//            // Handle the retrieved user
//        }
//    }
//
//    fun insertRecipe(recipe: FavoriteRecipe) {
//        viewModelScope.launch {
//            recipeDao.insertRecipe(recipe)
//        }
//    }
//
//
//
//    fun getFavoriteRecipes() {
//        viewModelScope.launch {
//            val favoriteRecipes = recipeDao.getAllFavorites()
//            // Handle the retrieved favorite recipes
//        }
//    }