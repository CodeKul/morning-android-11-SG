package com.codekul.sqlite

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.Room
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

class MyContentProvider : ContentProvider() {

    private var db: AppDb? = null
    private var helper: SupportSQLiteOpenHelper? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun getType(uri: Uri): String? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate(): Boolean {

        db = Room.databaseBuilder(
                context,
                AppDb::class.java,
                "mobileDb"
        ).build()

        helper = db?.openHelper

        return true
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?,
                       selectionArgs: Array<String>?, sortOrder: String?): Cursor? {

        // select (is_qwerty) from mobile where mob_typ = ? and mob_mnfr = ?

        return helper?.readableDatabase?.query(""" select * from mobile """)
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?,
                        selectionArgs: Array<String>?): Int {
        throw UnsupportedOperationException("Not yet implemented")
    }
}
