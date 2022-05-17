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
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.lifestyleapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var total = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.WorkoutsButton)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, WorkOutPage::class.java)
            startActivity(intent)
        }

        FastButton.setOnClickListener {
            val intent = Intent(this, FastingView::class.java).apply {
                putExtra(
                    AlarmClock.EXTRA_MESSAGE, "null"
                )
            }
            startActivity(intent)
            finish()
        }

        val halfButton: Button = findViewById(R.id.HalfBtn)
        val fullButton: Button = findViewById(R.id.FullBtn)
        val text:TextView = findViewById(R.id.TotalLiters)

        halfButton.setOnClickListener{
            total += 0.5
            text.setText(total.toString())
        }
        fullButton.setOnClickListener{
            total += 1.0
            text.setText(total.toString())
        }


    }
}