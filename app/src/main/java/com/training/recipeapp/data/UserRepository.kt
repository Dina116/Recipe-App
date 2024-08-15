package com.training.recipeapp.data

import androidx.lifecycle.LiveData
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class UserRepository(private var  userDao: UserDao,private var recipeDao:FavoriteRecipeDao ) {
   // val allUsers: LiveData<List<User>> = userDao.getAllUser()
 fun getAllUsers(): Flow<List<User>> =userDao.getAllUser()

    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

    suspend fun getUserByEmail(email: String): User? {
        return withContext(Dispatchers.IO){ userDao.getUserByEmail(email)}
    }

    suspend fun insertRecipe(recipe: FavoriteRecipe) {
        recipeDao.insertRecipe(recipe)
    }

    fun getAllFavorites(): Flow<List<FavoriteRecipe>> {
        return recipeDao.getAllFavorites()
    }

    suspend fun deleteRecipe(recipe: FavoriteRecipe) {
        recipeDao.delete(recipe)
    }


}

