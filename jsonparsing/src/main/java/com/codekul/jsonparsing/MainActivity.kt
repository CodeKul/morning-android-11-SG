package com.codekul.jsonparsing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usinGson()

        callWs()
    }

    private fun json() = assets.open("my.json").bufferedReader().use { it.readText() }

    fun usingJsonObject() {

        val rtObj = JSONObject(json())
        val nm = rtObj.getString("nm")
        val age = rtObj.getInt("age")
        val btry = rtObj.getInt("btry")
        Log.i("@codekul", """ Name - $nm Age - $age Battery $btry """)

        val mb = rtObj.getJSONObject("mb")
        val cst = mb.getString("cst")
        val isTouch = mb.getBoolean("isTouch")
        Log.i("@codekul", """ CST - $cst Touch Screen - $isTouch """)

        val lngs = rtObj.getJSONArray("lngs")
        for (i in 0..lngs.length()) {
            Log.i("@codekul", "${lngs.get(i)}")
        }
    }

    fun usinGson() {
        val gson = Gson()
        val my = gson.fromJson<MyJson>(json(), MyJson::class.java)
        Log.i("@CodeKul", """
            Name ${my.nm} ,
            Age ${my.age}
        """.trimIndent())
    }

    private fun callWs() {
        (applicationContext as App).q.add(
                StringRequest(
                        "https://randomuser.me/api/",
                        Response.Listener<String> {
                            Log.i("@codekul", it)

                            val res = (applicationContext as App).gsn.fromJson<MyNm>(it, MyNm::class.java)
                            res.results.forEach {
                                Log.i("@codekul", it.email)
                            }
                        },
                        Response.ErrorListener {
                            Log.i("@codekul", it.toString())
                        }
                )
        )
    }

    private fun pstDt() {
        // while posting JSON to server

        val obj = JSONObject()
        obj.put("nm", "android")
        obj.put("age", 12)

        (applicationContext as App).q.add(
                JsonObjectRequest(
                        "",
                        obj,
                        Response.Listener<JSONObject> { },
                        Response.ErrorListener { }
                )
        )
    }
}
