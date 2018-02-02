package com.codekul.sqlite

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by aniruddha on 2/2/18.
 */
@Entity
class Mobile {

    @PrimaryKey
    var mbId : Long? = null

    @ColumnInfo(name = "mob_typ")
    var typ : String? = null

    @ColumnInfo(name="mob_mnfr")
    var mnFr : String? = null

    @ColumnInfo(name="is_qwerty")
    var isQw : Boolean? = null
}