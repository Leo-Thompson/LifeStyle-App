package com.example.lifestyleapp

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.lifestyleapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        val button: Button = findViewById(R.id.WorkoutsButton)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, WorkOutPage::class.java)
            startActivity(intent)
        }

        FastButton.setOnClickListener { val intent = Intent(this, FastingView::class.java).apply { putExtra(
            AlarmClock.EXTRA_MESSAGE, "null") }
            startActivity(intent)
            finish() }
    }
}