package com.example.lifestyleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InterWorkOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inter_work_out)
        val button: Button = findViewById(R.id.RtnBtn3)
        button.setOnClickListener {
            val intent = Intent(this@InterWorkOut, WorkOutPage::class.java)
            startActivity(intent)
        }
    }
}