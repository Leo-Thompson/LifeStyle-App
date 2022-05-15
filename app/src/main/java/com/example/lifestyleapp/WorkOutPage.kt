package com.example.lifestyleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WorkOutPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_out_page)
        title = "KotlinApp"
        val button: Button = findViewById(R.id.easyButton)
        button.setOnClickListener {
            val intent = Intent(this@WorkOutPage, EasyWorkOut::class.java)
            startActivity(intent)
        }
        val button2: Button = findViewById(R.id.interbtn)
        button2.setOnClickListener{
            val intent = Intent(this@WorkOutPage, InterWorkOut::class.java)
            startActivity(intent)
        }
        val button3: Button = findViewById(R.id.extbtn)
        button3.setOnClickListener{
            val intent = Intent(this@WorkOutPage, ExtremeWorkOut::class.java)
            startActivity(intent)
        }


       val mainButton: Button = findViewById(R.id.MenuBtn)
       mainButton.setOnClickListener {
           val intent = Intent(this@WorkOutPage, MainActivity::class.java)
           startActivity(intent)
       }
    }

}