package com.example.lifestyleapp

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


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
        val cambutton: Button = findViewById(R.id.CaloriesTracker)
        cambutton.setOnClickListener{checkCam()}
    }
    fun checkCam() {
        var camPermissions = ContextCompat.checkSelfPermission(this, "android.permission.CAMERA")
        if (camPermissions != PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(this@MainActivity, CameraView::class.java)
                startActivity(intent)
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    "android.permission.CAMERA",
                    "android.permission.READ_EXTERNAL_STORAGE",
                    "android.permission.WRITE_EXTERNAL_STORAGE"
                ),
                1
            )
        }
    }


}