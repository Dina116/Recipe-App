package com.training.recipeapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.training.recipeapp.R
import com.training.recipeapp.data.UserRepository
import com.training.recipeapp.data.UserViewModel
import kotlinx.coroutines.launch
import org.mindrot.jbcrypt.BCrypt

class LoginFragment : Fragment() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userEmailEditText = view.findViewById<TextInputLayout>(R.id.et_user_name)
        val passwordEditText = view.findViewById<TextInputLayout>(R.id.et_password)
        val noAccountTextView = view.findViewById<TextView>(R.id.no_account)
        val loginButton = view.findViewById<Button>(R.id.login)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        loginButton.setOnClickListener {
            val email = userEmailEditText.editText?.text.toString()
            val password = passwordEditText.editText?.text.toString()

            lifecycleScope.launch {
                val user = userViewModel.getUser(email)
                if (user != null && BCrypt.checkpw(password, user.hashedPassword)) {
                    val prefs =
                        requireActivity().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    with(prefs.edit()) {
                        putBoolean("isLoggedIn", true)
                        apply()
                    }
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                } else {
                    requireActivity().runOnUiThread {
                        Toast.makeText(
                            requireContext(),
                            "Invalid email or password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }


                noAccountTextView.setOnClickListener {
                    findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
                }

            }
        }
    }

}