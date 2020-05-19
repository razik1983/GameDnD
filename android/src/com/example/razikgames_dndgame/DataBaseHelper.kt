package com.example.razikgames_dndgame

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream


class DataBaseHelper(private val fContext: Context) : SQLiteOpenHelper(fContext, DB_NAME, null, 1) {
    val isDebug = false
    private val TAG = this.javaClass.simpleName
    fun MyLogger(statement: String) {
        if (isDebug) {
            Log.d(TAG, statement)
        }
    }


    private var dataBase: SQLiteDatabase? = null
    @Throws(IOException::class)
    fun createDataBase() {
        val dbExist = checkDataBase()
        if (dbExist) { //ничего не делаем – файл базы данных уже есть
        } else {
            this.readableDatabase
            try {
                copyDataBase()
            } catch (e: IOException) {
                throw Error("Error copying database")
            }
        }
    }

    private fun checkDataBase(): Boolean {
        var checkDB: SQLiteDatabase? = null
        try {
            val myPath = DB_PATH + DB_NAME
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY)
        } catch (e: SQLiteException) { //файл базы данных отсутствует
        }
        checkDB?.close()
        return if (checkDB != null) true else false
    }

    @Throws(IOException::class)
    private fun copyDataBase() {
        val input = fContext.assets.open(DB_NAME)
        val outFileName = DB_PATH + DB_NAME
        val output: OutputStream = FileOutputStream(outFileName)
        val buffer = ByteArray(1024)
        var length: Int
        while (input.read(buffer).also { length = it } > 0) {
            output.write(buffer, 0, length)
        }
        output.flush()
        output.close()
        input.close()
        MyLogger("База скопирована на устройство")
    }

    @Throws(SQLException::class)
    fun openDataBase() {
        val path = DB_PATH + DB_NAME
        dataBase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY)
    }

    @Synchronized
    override fun close() {
        if (dataBase != null) dataBase!!.close()
        super.close()
    }

    override fun onCreate(db: SQLiteDatabase) {}
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    companion object {
        //private const val DB_PATH = "/data/data/com.example.razikgames_dndgame/databases/"
        private var DB_PATH: String? = null
        private const val DB_NAME = "Data.db"
    }
    init {
        DB_PATH = fContext.filesDir.path// + DB_NAME
    }

}


/*internal class DatabaseHelper(private val myContext: Context) : SQLiteOpenHelper(myContext, DB_NAME, null, SCHEMA) {
    override fun onCreate(db: SQLiteDatabase) {}
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
    fun create_db() {
        var myInput: InputStream? = null
        var myOutput: OutputStream? = null
        try {
            val file = File(DB_PATH)
            if (!file.exists()) {
                this.readableDatabase
                //получаем локальную бд как поток
                myInput = myContext.assets.open(DB_NAME)
                // Путь к новой бд
                val outFileName = DB_PATH
                // Открываем пустую бд
                myOutput = FileOutputStream(outFileName)
                // побайтово копируем данные
                val buffer = ByteArray(1024)
                var length: Int
                while (myInput.read(buffer).also({ length = it }) > 0) {
                    myOutput.write(buffer, 0, length)
                }
                myOutput.flush()
                myOutput.close()
                myInput.close()
            }
        } catch (ex: IOException) {
            Log.d("DatabaseHelper", ex.message)
        }
    }

    @Throws(SQLException::class)
    fun open(): SQLiteDatabase {
        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE)
    }

    companion object {
        private var DB_PATH : String? = null
        private const val DB_NAME = "cityinfo.db"
        private const val SCHEMA = 1 // версия базы данных
        const val TABLE = "users" // название таблицы в бд
        // названия столбцов
        const val COLUMN_ID = "_id"
        const val COLUMN_NAME = "name"
        const val COLUMN_YEAR = "year"
    }

    init {
        DB_PATH = myContext.filesDir.path + DB_NAME
    }
}*/