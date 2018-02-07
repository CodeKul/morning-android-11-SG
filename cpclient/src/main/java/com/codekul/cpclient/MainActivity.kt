package com.codekul.cpclient

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contacts()
    }

    private fun contacts() {

        val cursor = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                arrayOf(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER
                ),
                null,
                null,
                null
        )
        while(cursor.moveToNext()) {
            val nm = cursor.getString(0)
            val num = cursor.getString(1)

            Log.i("@codekul", """ Name is $nm Number is $num """)
        }
    }

    fun ourProvider() {
        val cursor = contentResolver.query(
                Uri.parse("content://com.codekul.my.key"),
                null,
                null,
                null,
                null
        )
        while(cursor.moveToNext()) {
            Log.i("@codekul",""" Type ${cursor.getString(cursor.getColumnIndex("mob_typ"))}""")
            Log.i("@codekul","""  Id ${cursor.getLong(0)} """)
            Log.i("@codekul",""" Mnfr ${cursor.getString(cursor.getColumnIndex("mob_mnfr"))}""")
            Log.i("@codekul",""" Qwerty ${cursor.getString(cursor.getColumnIndex("is_qwerty"))}""")
        }
    }
}
