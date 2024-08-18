package com.training.recipeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.training.recipeapp.databinding.FragmentSearchBinding

import com.training.recipeapp.mealadpter.mealadpter

import com.training.recipeapp.viewmodel.HomeViewModel


class SearchFragment : Fragment() {

private lateinit var binding:FragmentSearchBinding
private lateinit var viewModel:HomeViewModel
   private lateinit var SearchRecyclerviewadpter:mealadpter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(this).get(HomeViewModel::class.java)
    }
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preparRecyclerView()
        binding.imgSearch.setOnClickListener{
            searchmeals()
        }
        observeSearchedMealsLiveDate()

    }
    private fun observeSearchedMealsLiveDate(){
        viewModel.observSearchedmealsLiveData().observe(viewLifecycleOwner) { mealslist ->
            SearchRecyclerviewadpter.differ.submitList(mealslist)
        }
    }
    private fun searchmeals(){
        val searchQuery =binding.searchBox.text.toString()
        if (searchQuery.isNotEmpty())
        {
            viewModel.searchMeals(searchQuery)
        }
    }

    private fun preparRecyclerView(){
        SearchRecyclerviewadpter=mealadpter()
        binding.rvSearchMeals.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=SearchRecyclerviewadpter
        }
    }
}