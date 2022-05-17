package com.example.lifestyleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EasyWorkOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_work_out)
        val button: Button = findViewById(R.id.RtnBtn1)
        button.setOnClickListener {
            val intent = Intent(this@EasyWorkOut, WorkOutPage::class.java)
            startActivity(intent)
        }
    }
}