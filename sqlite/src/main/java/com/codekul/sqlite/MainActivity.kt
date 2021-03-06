package com.codekul.sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.persistence.room.Room
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
                applicationContext,
                AppDb::class.java,
                "mobileDb"
        ).build()

        Thread {
            val mob = Mobile()
            mob.isQw = true
            mob.mnFr = "Moto"
            mob.typ = "TAB"

            db.mobDao().saveMobile(mob)

            db.mobDao().mobiles().forEach {
                Log.i("@codekul", """ Type -  ${it.typ}""")
                Log.i("@codekul", """ MnFr -  ${it.mnFr}""")
                Log.i("@codekul", """ Id -  ${it.mbId}""")
                Log.i("@codekul", """ QWERTY -  ${it.isQw}""")
            }
        }.start()

    }
}
