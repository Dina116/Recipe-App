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
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.training.recipeapp.data.UserViewModel
import com.training.recipeapp.home.FavoritesFragment
import com.training.recipeapp.home.HomeFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UserViewModel
        userViewModel = UserViewModel(application)

        // Set up the toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Apply custom font to toolbar title
        val typeface = ResourcesCompat.getFont(this, R.font.aladin) // Update to your font resource
        typeface?.let {
            toolbar.title = SpannableString(toolbar.title).apply {
                setSpan(CustomTypefaceSpan("", it), 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            }
        }

        // Set up BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_favorites -> {
                    loadFragment(FavoritesFragment())
                    true
                }
                else -> false
            }
        }

        // Apply window insets for edge-to-edge support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom)
            WindowInsetsCompat.CONSUMED
        }

        // Load the default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, HomeFragment())
                .commit()
        }
    }

    // Method to load a fragment into the container
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        menu?.let { applyFontToMenuItem(it) }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_search -> {
                // Handle search action
                true
            }
            R.id.menu_sign_out -> {
                signOut()
                true
            }
            R.id.menu_about_creators -> {
                // Handle about creators action
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun signOut() {
        clearUserData()

        // Create an Intent to start LoginActivity
        val intent = Intent(this, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        // Start LoginActivity
        startActivity(intent)

        // Finish the current activity
        finish()
    }

    private fun clearUserData() {
        // Use ViewModel to clear user data
        CoroutineScope(Dispatchers.IO).launch {
            userViewModel.clearAllUsers()  // Ensure clearAllUsers() is properly defined in UserViewModel

            // Optionally clear SharedPreferences if you are using it
            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                clear()
                apply()
            }
        }
    }

    private fun applyFontToMenuItem(menu: Menu) {
        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            val spannableTitle = SpannableString(menuItem.title)
            val typeface = ResourcesCompat.getFont(this, R.font.aladin) // Update to your font resource
            typeface?.let {
                spannableTitle.setSpan(CustomTypefaceSpan("", it), 0, spannableTitle.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            }
            menuItem.title = spannableTitle
        }
    }

    private class CustomTypefaceSpan(family: String, private val newType: Typeface) : TypefaceSpan(family) {
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
