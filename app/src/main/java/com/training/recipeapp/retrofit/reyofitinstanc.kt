package com.training.recipeapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object reyofitinstanc {
    val api:meal by lazy {
        Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/").addConverterFactory(GsonConverterFactory.create())
            .build().create(meal::class.java)    }
}