package com.training.recipeapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)var id:Int,
    @ColumnInfo(name ="email" ) var email: String,

    @ColumnInfo(name = "username") var username: String,
    @ColumnInfo(name = "hashedPassword") var hashedPassword: String
):Serializable{
    constructor():this(0,"","","")
}
