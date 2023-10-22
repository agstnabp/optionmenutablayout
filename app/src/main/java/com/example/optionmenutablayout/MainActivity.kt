package com.example.optionmenutablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.optionmenutablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    companion object{
        var username = ""
        var email= ""
        var no = ""
        var password= ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            viewPager.adapter = TabAdapter(this@MainActivity)
            TabLayoutMediator(tabLayout,viewPager) { tab, position ->
                tab.text = when (position) {
                    0 -> "Login"
                    1 -> "Register"
                    else -> ""
                }
            }.attach()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }


}