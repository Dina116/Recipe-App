package com.training.recipeapp

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.graphics.Paint
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.TypefaceSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.training.recipeapp.fragments.CreatorFragment
import com.training.recipeapp.fragments.HomeFragment

@Suppress("DEPRECATION")
class RecipeActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val toolbar: Toolbar = findViewById(R.id.appbar)
        setSupportActionBar(toolbar)

        // Setup Navigation Component
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_Recipefragment) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.homeFragment) // Navigate to HomeFragment
                    true
                }
                R.id.navigation_favorites -> {
                    navController.navigate(R.id.favoritesFragment) // Navigate to FavoritesFragment
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        applyFontToMenuItem(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_Singout -> {
                val intentActivity = Intent(this, AuthActivity::class.java)
                startActivity(intentActivity)
                val prefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                with(prefs.edit()) {
                    putBoolean("isLoggedIn", false)
                    apply()
                }
                true
            }
            R.id.action_creator -> {
                navController.navigate(R.id.creatorFragment) // Navigate to CreatorFragment using NavController
                true
            }
            // Remove or replace this line if it's not used
            // R.id.action_homeFragment_to_favFragment -> {
            //    navController.navigate(R.id.favoritesFragment) // Navigate to FavoritesFragment using NavController
            //    true
            // }
            else -> {
                Toast.makeText(this, "Other is clicked", Toast.LENGTH_SHORT).show()
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun applyFontToMenuItem(menu: Menu?) {
        menu?.let {
            for (i in 0 until it.size()) {
                val menuItem = it.getItem(i)
                val spannableTitle = SpannableString(menuItem.title)
                val typeface = ResourcesCompat.getFont(this, R.font.aladin)
                typeface?.let {
                    spannableTitle.setSpan(CustomTypefaceSpan("", it), 0, spannableTitle.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                }
                menuItem.title = spannableTitle
            }
        }
    }

    class CustomTypefaceSpan(family: String, private val newType: Typeface) : TypefaceSpan(family) {
        override fun updateDrawState(ds: TextPaint) {
            applyCustomTypeFace(ds, newType)
        }

        override fun updateMeasureState(paint: TextPaint) {
            applyCustomTypeFace(paint, newType)
        }

        private fun applyCustomTypeFace(paint: Paint, tf: Typeface) {
            val oldStyle: Int
            val old = paint.typeface
            oldStyle = old?.style ?: 0

            val fake = oldStyle and tf.style.inv()
            if (fake and Typeface.BOLD != 0) {
                paint.isFakeBoldText = true
            }

            if (fake and Typeface.ITALIC != 0) {
                paint.textSkewX = -0.25f
            }

            paint.typeface = tf
        }
    }
}
