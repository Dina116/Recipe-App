package com.training.recipeapp.data

import androidx.lifecycle.LiveData
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private var  userDao: UserDao,private var recipeDao:FavoriteRecipeDao ) {
    val allUsers: LiveData<List<User>> = userDao.getAllUser()

    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

    suspend fun getUserByEmail(email: String): LiveData<User> {
        return userDao.getUserByEmail(email)
    }

    suspend fun insertRecipe(recipe: FavoriteRecipe) {
        recipeDao.insertRecipe(recipe)
    }

    fun getAllFavorites(): LiveData<List<FavoriteRecipe>> {
        return recipeDao.getAllFavorites()
    }

    suspend fun deleteRecipe(recipe: FavoriteRecipe) {
        recipeDao.delete(recipe)
    }


}
//    private val db = Room.databaseBuilder(
//        context.applicationContext,
//        AppDatabase::class.java, "app_database"
//    ).build()

// private val userDao = db.userDao()
//private val recipeDao=db.favoriteRecipeDao()
