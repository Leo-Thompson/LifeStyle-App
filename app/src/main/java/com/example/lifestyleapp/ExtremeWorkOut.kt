package com.example.lifestyleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ExtremeWorkOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extreme_wor_out)
        val button: Button = findViewById(R.id.RtnBtn2)
        button.setOnClickListener {
            val intent = Intent(this@ExtremeWorkOut, WorkOutPage::class.java)
            startActivity(intent)
        }
    }
}