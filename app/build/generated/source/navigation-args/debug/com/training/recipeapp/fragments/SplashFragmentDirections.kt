package com.training.recipeapp.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.training.recipeapp.R

public class SplashFragmentDirections private constructor() {
  public companion object {
    public fun actionSplashFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_loginFragment)

    public fun actionSplashFragmentToMainActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_mainActivity)
  }
}
