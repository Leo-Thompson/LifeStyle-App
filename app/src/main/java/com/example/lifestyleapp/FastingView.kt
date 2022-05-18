package com.example.lifestyleapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.AlarmClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fasting_view.*


var startedFast: Long? = null
var stoppedFast: Long? = null
var stopIt: Boolean = false
var fastingCountDown: CountDownTimer? = null
var mHoursFasted: Int = 0
var testDEMO: String? = null
var tried = false
class FastingView: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fasting_view)

        startDemo.setOnClickListener {
            var currentDate = System.currentTimeMillis()
            //bring to right format   // get date
            var currentDateInMinutes = currentDate!!
            startedFast = currentDateInMinutes
            fastingCountDown = object : CountDownTimer(10000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    progressBar.progress += (10)
                    hoursFasted.setText("Seconds remaining: " + ((millisUntilFinished) / 1000))
                }
                override fun onFinish() {
                    progressBar.progress += (10)
                    hoursFasted.setText("Fast Finished")
                    mHoursFasted += 0
                    testDEMO = "DEMO FAST FINISHED SUCCESSFULLY"
                }
            }.start()
            stopFast.setOnClickListener {
                fastingCountDown!!.cancel()
                hoursFasted.text = "0"
                progressBar.progress = 0
            }
        }


        m16hrFast.setOnClickListener {
            var hoursLeftText = 0
            var textString = "${hoursLeftText}/16"
            var currentDate = System.currentTimeMillis()
            tried = true

            //bring to right format   // get date
            var currentDateInMinutes = currentDate!!
            startedFast = currentDateInMinutes
            var count = 0
            fastingCountDown = object : CountDownTimer(57600000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    count++
                    if (count % 5700 == 0){
                        progressBar.progress += 10
                        hoursLeftText +=1
                        hoursLeft.text = textString
                    }
                    hoursFasted.setText("Minutes remaining: " + ((millisUntilFinished) / 60000))
                    hoursLeft.text = textString
                }
                override fun onFinish() {
                    progressBar.progress += (10)
                    hoursFasted.setText("Fast Finished")
                    mHoursFasted += 16
                }
            }.start()
            stopFast.setOnClickListener {
                fastingCountDown!!.cancel()
                hoursFasted.text = "0"
                progressBar.progress = 0
                hoursLeft.text = ""
            }
        }
        exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("hoursFasted", mHoursFasted)
            if (testDEMO != null){
                intent.putExtra("demoSuccess", testDEMO)
            }
            intent.putExtra("tried", tried)
            startActivity(intent)
            finish()
        }
    }
    override fun onClick(p0: View?) {

    }
}