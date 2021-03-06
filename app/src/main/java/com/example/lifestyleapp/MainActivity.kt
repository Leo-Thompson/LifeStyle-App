package com.example.lifestyleapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
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
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
var totalWater: Float = 0.0f
var completedFasts: Int = 0
var failedFasts: Int = 0
var totalCaloriesInt: Int = 0
var done = false

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.WorkoutsButton)

        //completedFasts += intent.extras!!.getInt("completedFasts")
        //failedFasts += intent.extras!!.getInt("failedFasts")

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, WorkOutPage::class.java)
            startActivity(intent)
        }

        val cal: Button = findViewById(R.id.CaloriesTracker)
        cal.setOnClickListener{
            val intent = Intent(this@MainActivity, CameraView::class.java)
            startActivity(intent)
            finish()
        }
        FastButton.setOnClickListener {
            val intent = Intent(this, FastingView::class.java).apply {
                putExtra(
                    AlarmClock.EXTRA_MESSAGE, "null"
                )
            }
            intent.putExtra("completedFasts", completedFasts)
            intent.putExtra("failedFasts", failedFasts)
            startActivity(intent)
            finish()
        }

        val halfButton: Button = findViewById(R.id.HalfBtn)
        val fullButton: Button = findViewById(R.id.FullBtn)
        val text:TextView = findViewById(R.id.TotalLiters)
        halfButton.setOnClickListener{
            TotalLiters.text = (TotalLiters.text.toString().toFloat() + 0.5).toString()
            totalWater += 0.5f
        }
        fullButton.setOnClickListener{
            TotalLiters.text = (TotalLiters.text.toString().toFloat() + 1).toString()
            totalWater +=1
        }
        TotalLiters.text = totalWater.toString()



        var m16Tried = intent.extras?.getBoolean("16tried")
        var m16Completed = intent.extras?.getBoolean("16Completed")
        var demoTried = intent.extras?.getBoolean("DEMOtried")
        var demoCompleted = intent.extras?.getBoolean("DEMOCompleted")

        if (m16Tried == true && m16Completed == true){
            completedFasts +=1
        } else if (m16Tried == true && m16Completed == false){
            failedFasts +=1
        }
        TotalFasts.text = completedFasts.toString()
        TotalFastsFailed.text = failedFasts.toString()


        var caloriesTried = intent.extras?.getBoolean("caloriesTried")
        var caloriesInt = intent.extras?.getString("calories")


        if (caloriesTried == true){
            caloriesInt = caloriesInt!!.trim()
            totalCaloriesInt += caloriesInt.toInt()
            TotalCalories.text = totalCaloriesInt.toString()
        } else {
            done = true
            TotalCalories.text = totalCaloriesInt.toString()
        }

        if (demoTried == true && demoCompleted == true){
            Toast.makeText(this,"DEMO fast completed", Toast.LENGTH_LONG).show()
        } else if ( demoTried == true && demoCompleted == false){
            Toast.makeText(this,"DEMO fast failed", Toast.LENGTH_LONG).show()
        }


    // barcodes food products
        // 5060335635174
        // 04963406


    }
}