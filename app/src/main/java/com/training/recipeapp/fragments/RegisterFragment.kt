package com.training.recipeapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.training.recipeapp.R
import com.training.recipeapp.data.User
import com.training.recipeapp.data.UserRepository
import com.training.recipeapp.data.UserViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.mindrot.jbcrypt.BCrypt

class RegisterFragment : Fragment() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val registerButton = view.findViewById<Button>(R.id.b_register)
        val emailEditText = view.findViewById<TextInputLayout>(R.id.etregister_email)
        val usernameEditText = view.findViewById<TextInputLayout>(R.id.etregister_username)
        val passwordEditText = view.findViewById<TextInputLayout>(R.id.etregister_password)

        registerButton.setOnClickListener {
            val id=0
            val email = emailEditText.editText?.text.toString()
            val username = usernameEditText.editText?.text.toString()
            val password = passwordEditText.editText?.text.toString()
            val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())

            val user = User(id=0,email = email, username = username, hashedPassword = hashedPassword)

            //ViewModelScope dose not play with me

          GlobalScope.launch {
                userViewModel.insertUser(user)
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }
        val prefs = requireActivity().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        with(prefs.edit()) {
            putBoolean("isLoggedIn", true)
            apply()
        }

    }

}