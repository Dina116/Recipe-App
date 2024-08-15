package com.training.recipeapp.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.training.recipeapp.R


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.postDelayed({
            val pref = requireActivity().getSharedPreferences("app_pref", Context.MODE_PRIVATE)
            val isLoggedIn = pref.getBoolean("isLoggedIn", false)

            // Log current destination ID
            val currentDestinationId = findNavController().currentDestination?.id
            Log.d("SplashFragment", "Current Destination ID: $currentDestinationId")

                if (isLoggedIn) {
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                }
            }, 2000)
        }
    }
