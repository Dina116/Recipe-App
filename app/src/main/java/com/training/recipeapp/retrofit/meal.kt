package com.training.recipeapp.retrofit

import com.training.recipeapp.data.recipeclass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface meal {
    @GET("search.php")
    fun searchmeals(@Query("s")searchQuery:String):Call<recipeclass>
}