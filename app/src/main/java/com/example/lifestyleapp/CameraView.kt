package com.example.lifestyleapp

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.camera_view.*
import java.net.HttpURLConnection
import java.net.URL


class CameraView: AppCompatActivity() {


    fun getBarData(barcode: String): MutableList<String> {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var infoString = mutableListOf<String>()

        val url =
            URL("https://world.openfoodfacts.org/api/v2/product/$barcode.json?fields=product_name,energy-kcal_serving,carbohydrates_serving,fat_serving,proteins_serving,salt_serving,sugars_serving")
        try {
            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET

                println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
                inputStream.bufferedReader().use {

                    it.lines().forEach { line ->
                        println(line)
                        infoString.add(line)
                    }
                }
            }
        }
        catch(e: Throwable){
            throw(e)
        }
        return(infoString)

    }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.camera_view)
            barcodeEntryTitle.isEnabled = true
            barcodeEntryTitle.isFocusable = true

            val button: Button = findViewById(R.id.workoutsButton)
            button.setOnClickListener {
                val intent = Intent(this@CameraView, WorkOutPage::class.java)
                startActivity(intent)
            }
            val button2: Button = findViewById(R.id.fastButton)
            button2.setOnClickListener {
                val intent = Intent(this@CameraView, FastingView::class.java)
                startActivity(intent)
            }
            val button3: Button = findViewById(R.id.menuButton)
            button3.setOnClickListener {
                val intent = Intent(this@CameraView, MainActivity::class.java)
                startActivity(intent)
            }
            val sendButton: Button = findViewById(R.id.send_button)
            sendButton.setOnClickListener {
                val userBarcode = barcodeEntryText.text
                val retrievedData = getBarData(userBarcode.toString())
                barAccept.text = retrievedData.toString()
                Log.d("HelpMePlease", "$retrievedData")
                Log.d("HelpMePlease", "0... ${retrievedData[0]}")

            }


        }

    }







