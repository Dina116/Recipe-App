package com.training.recipeapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.recipeapp.data.Meal
import com.training.recipeapp.data.recipeclass
import com.training.recipeapp.retrofit.reyofitinstanc
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel :ViewModel(){
    private val searchedModelLiveData=MutableLiveData<List<Meal>>()
    fun searchMeals(searchQuery:String)=reyofitinstanc.api.searchmeals(searchQuery).enqueue(
        object :Callback<recipeclass>{
            override fun onResponse(call: Call<recipeclass>, response: Response<recipeclass>) {
                val mealslist=response.body()?.meals
                mealslist?.let {
                    searchedModelLiveData.postValue(it)
                }
            }

            override fun onFailure(call: Call<recipeclass>, t: Throwable) {
                Log.e("HomeViewModel","error in search")
            }

        }

    )
    fun observSearchedmealsLiveData():LiveData<List<Meal>> = searchedModelLiveData
}