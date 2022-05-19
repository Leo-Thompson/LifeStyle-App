package com.example.lifestyleapp

import android.app.Activity
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
var triedDEMO: Boolean = false
var completedDEMO = false


var tried16 = false
var sixteenHourFastCompleted = false


class FastingView: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fasting_view)
        var completedFasts = intent.extras!!.getInt("completedFasts")
        var failedFasts = intent.extras!!.getInt("failedFasts")

        startDemo.setOnClickListener {
            var currentDate = System.currentTimeMillis()
            //bring to right format   // get date
            var currentDateInMinutes = currentDate!!
            triedDEMO = true
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
                    completedDEMO = true
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
            tried16 = true

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
                    sixteenHourFastCompleted = true
                    hoursFasted.setText("Fast Finished")
                    mHoursFasted += 16
                    completedFasts +=1
                }
            }.start()
            stopFast.setOnClickListener {
                fastingCountDown!!.cancel()
                hoursFasted.text = "0"
                progressBar.progress = 0
                hoursLeft.text = ""
                failedFasts +=1
            }
        }
        exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("16Completed", sixteenHourFastCompleted)
            intent.putExtra("16tried", tried16)
            intent.putExtra("DEMOtried", triedDEMO)
            intent.putExtra("DEMOCompleted", completedDEMO)
            startActivity(intent)
            intent.putExtra("failedFasts", failedFasts)
            intent.putExtra("completedFasts", completedFasts)
            intent.putExtra("result", "RESULT OKOK OKO")
            setResult(Activity.RESULT_OK, intent)
            sixteenHourFastCompleted = false
            tried16 = false
            triedDEMO = false
            completedDEMO = false
        }
    }
    override fun onClick(p0: View?) {

    }
}