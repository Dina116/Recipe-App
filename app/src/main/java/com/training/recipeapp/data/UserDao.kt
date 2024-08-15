package com.training.recipeapp.data

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun insert(user: User)

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1" )
  fun getUserByEmail(email: String):User?



    @Query("SELECT * FROM  users")
     fun getAllUser():LiveData<List<User>>



}


