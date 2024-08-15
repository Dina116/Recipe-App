package com.training.recipeapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favorite_recipes")
data class FavoriteRecipe(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var title: String,
    var imageUrl: String
):Serializable{
    constructor():this(0,"","")
}
