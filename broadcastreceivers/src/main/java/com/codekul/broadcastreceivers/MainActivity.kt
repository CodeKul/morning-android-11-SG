package com.codekul.broadcastreceivers

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private val br = MyReceiver()
    private val fltr = IntentFilter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fltr.addAction("com.codekul.my.action")
        fltr.addAction("android.intent.action.ACTION_POWER_CONNECTED")
        fltr.addAction("android.intent.action.ACTION_POWER_DISCONNECTED")
    }

    fun onOkay(vw : View?) {
        sendBroadcast(Intent("com.codekul.my.action"))
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(br, fltr)
    }

    override fun onStop() {
        unregisterReceiver(br)
        super.onStop()
    }
}
