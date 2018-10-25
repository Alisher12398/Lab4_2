package com.android.lab3

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.android.lab3.Activity.MainActivity
import com.android.lab3.Model.NewsModel
import java.util.ArrayList

class Database (context: Context) : SQLiteOpenHelper(context, "db", null, 1){

    override fun onCreate(db: SQLiteDatabase) {


        //val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, $NAME TEXT,$PASS TEXT);"
        val CREATE_TABLE = "CREATE TABLE News (id INTEGER PRIMARY KEY, title TEXT, date TEXT, text TEXT, image_url INTEGER);"
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


    fun addTask(news: NewsModel) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("title", news.title)
        values.put("date", news.date)
        values.put("text", news.text)
        values.put("image_url", news.image_url)
        db.insert("News", null, values)
        db.close()
    }


    fun parceDBtoList(): List<NewsModel> {
        val newsList = ArrayList<NewsModel>()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM News"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val news = NewsModel()
                    news.id = cursor.getInt(cursor.getColumnIndex("id"))
                    news.title = cursor.getString(cursor.getColumnIndex("title"))
                    news.date = cursor.getString(cursor.getColumnIndex("date"))
                    news.text = cursor.getString(cursor.getColumnIndex("text"))
                    news.image_url = cursor.getInt(cursor.getColumnIndex("image_url"))
                    newsList.add(news)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return newsList
    }

    fun selectByID(_id: Int): NewsModel {
        val tasks = NewsModel()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM News WHERE id = $_id"
        val cursor = db.rawQuery(selectQuery, null)

        cursor?.moveToFirst()
        tasks.id = cursor.getInt(cursor.getColumnIndex("id"))
        tasks.title = cursor.getString(cursor.getColumnIndex("title"))
        tasks.date = cursor.getString(cursor.getColumnIndex("date"))
        tasks.text = cursor.getString(cursor.getColumnIndex("text"))

        cursor.close()
        return tasks
    }


    fun deleteNews(_id: Int) {
        val db = this.writableDatabase
        db.delete("News", "id" + "=?", arrayOf(_id.toString())).toLong()
        db.close()
    }







}









/*
* fun addTask(tasks: Tasks): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME, tasks.name)
        values.put(DESC, tasks.desc)
        values.put(COMPLETED, tasks.completed)
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        Log.v("InsertedId", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }

    fun getTask(_id: Int): Tasks {
        val tasks = Tasks()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE $ID = $_id"
        val cursor = db.rawQuery(selectQuery, null)

        cursor?.moveToFirst()
        tasks.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
        tasks.name = cursor.getString(cursor.getColumnIndex(NAME))
        tasks.desc = cursor.getString(cursor.getColumnIndex(DESC))
        tasks.completed = cursor.getString(cursor.getColumnIndex(COMPLETED))
        cursor.close()
        return tasks
    }

    fun task(): List<Tasks> {
        val taskList = ArrayList<Tasks>()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                    do {
                    val tasks = Tasks()
                    tasks.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                    tasks.name = cursor.getString(cursor.getColumnIndex(NAME))
                    tasks.desc = cursor.getString(cursor.getColumnIndex(DESC))
                    tasks.completed = cursor.getString(cursor.getColumnIndex(COMPLETED))
                    taskList.add(tasks)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        return taskList
    }

    fun updateTask(tasks: Tasks): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME, tasks.name)
        values.put(DESC, tasks.desc)
        values.put(COMPLETED, tasks.completed)
        val _success = db.update(TABLE_NAME, values, ID + "=?", arrayOf(tasks.id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun deleteTask(_id: Int): Boolean {
        val db = this.writableDatabase
        val _success = db.delete(TABLE_NAME, ID + "=?", arrayOf(_id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun deleteAllTasks(): Boolean {
        val db = this.writableDatabase
        val _success = db.delete(TABLE_NAME, null, null).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }
*
*
* */