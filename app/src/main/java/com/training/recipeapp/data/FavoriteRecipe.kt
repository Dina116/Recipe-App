package com.training.recipeapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favorite_recipes")
data class FavoriteRecipe(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "user_name") var username: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "image_url") var imageUrl: String,
    @ColumnInfo(name = "ingredients") var ingredients: String,



    ):Serializable{
    constructor():this(0,"","","","")
}
