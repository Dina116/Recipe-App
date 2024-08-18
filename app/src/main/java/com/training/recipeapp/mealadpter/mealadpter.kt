package com.training.recipeapp.mealadpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.training.recipeapp.data.Meal
import com.training.recipeapp.databinding.FragmentSearchBinding
import com.training.recipeapp.databinding.ItemCardBinding

class mealadpter:RecyclerView.Adapter<mealadpter.FavoritMealsAdpterViewholder>() {
    inner class FavoritMealsAdpterViewholder(val binding: ItemCardBinding):RecyclerView.ViewHolder(binding.root)

    private val diffUtil =object:DiffUtil.ItemCallback<Meal>(){
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
           return oldItem==newItem
        }

    }
    val differ=AsyncListDiffer(this,diffUtil)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoritMealsAdpterViewholder {
         return FavoritMealsAdpterViewholder(
             ItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
         )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: FavoritMealsAdpterViewholder, position: Int) {
        val meal =differ.currentList[position]
        Glide.with(holder.itemView).load(meal.strMealThumb).into(holder.binding.ivProduct)
        holder.binding.tvProduct.text=meal.strMeal
    }

}