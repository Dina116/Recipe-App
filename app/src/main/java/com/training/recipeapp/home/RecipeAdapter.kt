package com.training.recipeapp.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.training.recipeapp.R

@Suppress("DEPRECATION")
class RecipeAdapter(
    private val recipes: List<Recipe>,
    private val onItemClick: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        // Display two recipes per row
        val recipeIndex1 = position * 2
        val recipeIndex2 = position * 2 + 1

        // Bind first recipe
        if (recipeIndex1 < recipes.size) {
            val recipe1 = recipes[recipeIndex1]
            holder.bindRecipe1(recipe1)
            holder.itemView.findViewById<LinearLayout>(R.id.recipeLayout1).setOnClickListener {
                onItemClick(recipe1)
            }
        }

        // Bind second recipe
        if (recipeIndex2 < recipes.size) {
            val recipe2 = recipes[recipeIndex2]
            holder.bindRecipe2(recipe2)
            holder.itemView.findViewById<LinearLayout>(R.id.recipeLayout2).setOnClickListener {
                onItemClick(recipe2)
            }
        }
    }

    override fun getItemCount(): Int {
        // Number of rows in RecyclerView
        return (recipes.size + 1) / 2
    }

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recipeName1: TextView = itemView.findViewById(R.id.recipeName1)
        private val recipeImage1: ImageView = itemView.findViewById(R.id.recipeImage1)
        private val recipeName2: TextView = itemView.findViewById(R.id.recipeName2)
        private val recipeImage2: ImageView = itemView.findViewById(R.id.recipeImage2)

        fun bindRecipe1(recipe: Recipe) {
            recipeName1.text = recipe.strMeal
            recipeImage1.load(recipe.strMealThumb)
        }

        fun bindRecipe2(recipe: Recipe) {
            recipeName2.text = recipe.strMeal
            recipeImage2.load(recipe.strMealThumb)
        }
    }
}
