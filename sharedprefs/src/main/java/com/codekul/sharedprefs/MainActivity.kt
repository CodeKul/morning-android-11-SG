package com.codekul.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onRead(view : View) {

        val shPrf = getSharedPreferences("myPrefs", MODE_PRIVATE)
        val nm = shPrf.getString("nm", "none")
        val age = shPrf.getInt("age", -2)
        val isOkay = shPrf.getBoolean("isOkay", false)
        val strength = shPrf.getFloat("strength", -9f)

        Log.i("@codekul", """ Name - $nm Age - $age isOkay - $isOkay Strength - $strength """)
    }

    fun onWrite(view : View) {
        val shPrf = getSharedPreferences("myPrefs", MODE_PRIVATE)
        val edtr = shPrf.edit()
        edtr.putString("nm", "android")
        edtr.putInt("age",15)
        edtr.putBoolean("isOkay", true)
        edtr.putFloat("strength", 45.6f)
        edtr.apply()
    }
}
