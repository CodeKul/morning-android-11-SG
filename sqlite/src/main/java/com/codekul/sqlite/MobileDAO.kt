package com.codekul.sqlite

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by aniruddha on 2/2/18.
 */
@Dao
interface MobileDAO {

    @Insert
    fun saveMobile(mob : Mobile)

    @Query("select * from mobile")
    fun mobiles() : List<Mobile>
}