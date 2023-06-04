package com.example.myapplication_firebase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper1 (

    context: Context,
    name: String = database,
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = v
    ) : SQLiteOpenHelper(context, name, factory, version) {
        companion object {
            private const val database = "myDatabase1"
            private const val  v = 1
        }

        override fun onCreate(db1: SQLiteDatabase?) {
            //建立 資料表
            db1?.execSQL("CREATE TABLE myTable1( name text NOT NULL, email text PRIMARY KEY, date text NOT NULL, people text NOT NULL) ")

        }

        override fun onUpgrade(db1: SQLiteDatabase?, oldVersion: Int,
                               newVersion: Int) {

            db1?.execSQL("DROP TABLE IF EXISTS myTable1")
            onCreate(db1)

        }
    }
