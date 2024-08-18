package com.training.recipeapp.home

import android.os.Bundle
import android.view.View
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

    private var isInstructionsVisible = false // Flag to keep track of visibility

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

        // Set up click listener for recipe name
        recipeNameTextView.setOnClickListener {
            toggleInstructionsVisibility()
        }
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
                        recipeInstructionsTextView.visibility = View.GONE // Hide instructions initially
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

    private fun toggleInstructionsVisibility() {
        isInstructionsVisible = !isInstructionsVisible
        recipeInstructionsTextView.visibility = if (isInstructionsVisible) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}
