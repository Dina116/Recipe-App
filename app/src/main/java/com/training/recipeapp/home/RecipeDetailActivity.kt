package com.training.recipeapp.home

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.training.recipeapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    private lateinit var recipeImageView: ImageView
    private lateinit var recipeNameTextView: TextView
    private lateinit var recipeInstructionsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        recipeImageView = findViewById(R.id.recipeImageView)
        recipeNameTextView = findViewById(R.id.recipeNameTextView)
        recipeInstructionsTextView = findViewById(R.id.recipeInstructionsTextView)

        // Initialize Retrofit
        apiService = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val recipeId = intent.getStringExtra("RECIPE_ID") ?: return
        fetchRecipeById(recipeId)
    }

    private fun fetchRecipeById(id: String) {
        apiService.getRecipeById(id).enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(
                call: Call<RecipeResponse>,
                response: Response<RecipeResponse>
            ) {
                if (response.isSuccessful) {
                    val recipe = response.body()?.meals?.firstOrNull()
                    recipe?.let {
                        recipeNameTextView.text = it.strMeal
                        recipeInstructionsTextView.text = it.strInstructions ?: "No instructions available"
                        recipeImageView.load(it.strMealThumb)
                    }
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
