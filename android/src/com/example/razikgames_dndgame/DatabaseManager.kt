package com.example.razikgames_dndgame

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseManager {
    private var mOpenCounter = 0
    private var mDatabase: SQLiteDatabase? = null
    @Synchronized
    fun openDatabase(): SQLiteDatabase? {
        mOpenCounter++
        if (mOpenCounter == 1) { // Opening new database
            mDatabase = mDatabaseHelper?.getWritableDatabase()
        }
        return mDatabase
    }

    @Synchronized
    fun closeDatabase() {
        mOpenCounter--
        if (mOpenCounter == 0) { // Closing database
            mDatabase?.close()
        }
    }

    companion object {
        private var instance: DatabaseManager? = null
        private var mDatabaseHelper: SQLiteOpenHelper? = null
        @Synchronized
        fun initializeInstance(helper: SQLiteOpenHelper?) {
            if (instance == null) {
                instance = DatabaseManager()
                mDatabaseHelper = helper
            }
        }

        @Synchronized
        fun getInstance(): DatabaseManager? {
            checkNotNull(instance) {
                DatabaseManager::class.java.simpleName +
                        " is not initialized, call initializeInstance(..) method first."
            }
            return instance
        }
    }
}