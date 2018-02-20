package com.codekul.jsonparsing

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

/**
 * Created by aniruddha on 20/2/18.
 */

class App : Application() {

    lateinit var q : RequestQueue
    lateinit var gsn : Gson

    override fun onCreate() {
        super.onCreate()
        q = Volley.newRequestQueue(this@App)

        gsn = Gson()
    }
}