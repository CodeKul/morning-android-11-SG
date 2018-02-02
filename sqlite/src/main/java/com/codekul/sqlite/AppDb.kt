package com.codekul.sqlite

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by aniruddha on 2/2/18.
 */
@Database(entities = [(Mobile::class)], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun mobDao(): MobileDAO
}