package com.example.optionmenutablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.optionmenutablayout.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val usernames = intent.getStringExtra("USERNAME")
        with(binding){
            welcome.text = "Welcome $usernames !!"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_logout -> {
                Toast.makeText(this@HomeActivity,"You've logging out", Toast.LENGTH_SHORT).show()
                val intentLogin = Intent(this@HomeActivity, MainActivity::class.java)
                startActivity(intentLogin)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}