package com.training.recipeapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.fragment.findNavController
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.training.recipeapp.fragments.CreatorFragment
import com.training.recipeapp.fragments.SearchFragment

class RecipeActivity : AppCompatActivity() {
    lateinit var imgsearch: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)


        imgsearch =findViewById(R.id.imghomesearcrh)
        val toolbar: Toolbar = findViewById(R.id.appbar)
        setSupportActionBar(toolbar)


        imgsearch.setOnClickListener{
            val fragmentManager=supportFragmentManager
            val transaction=fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_Recipefragment,SearchFragment(),"tag")
            transaction.setReorderingAllowed(true)
            transaction.addToBackStack("backstack")
            transaction.commit()
        }


//
//            override fun onQueryTextChange(newText: String?): Boolean {
//
//                return true
//            }
//        })
//    }
}


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)


        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId) {
            R.id.action_Singout-> {
                val intentActivity = Intent(this, AuthActivity::class.java)
                startActivity(intentActivity)
                val prefs =
                    getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                with(prefs.edit()) {
                    putBoolean("isLoggedIn", false)
                    apply()}

            }R.id.action_creator-> {
            val fragmentManager=supportFragmentManager
            val transaction=fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_Recipefragment,CreatorFragment(),"tag")
            transaction.setReorderingAllowed(true)
            transaction.addToBackStack("backstack")
            transaction.commit()


        }
            else-> Toast.makeText(this,"other is clicked", Toast.LENGTH_SHORT).show()
        }
        return true
    }

}