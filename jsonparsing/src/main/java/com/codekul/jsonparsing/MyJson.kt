package com.codekul.jsonparsing

import java.util.ArrayList

/**
 * Created by aniruddha on 14/2/18.
 */
data class MyJson(
        val nm: String,
        val age: Int,
        val btry: Int,
        val mb: Mobile,
        val lngs: ArrayList<String>
)

data class Mobile(
        val cst: String,
        val isTouch: Boolean
)