package com.example.bayrakquizuygulamas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context):SQLiteOpenHelper(context,"bayrakquiz.sqlite",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS\"bayraklar\" (\n" +
                "\t`bayrak_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`bayrak_ad`\tTEXT,\n" +
                "\t`bayrak_resim`\tTEXT\n" +
                ")")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS bayraklar")
        onCreate(db)
    }

}