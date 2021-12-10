package com.example.practicekotlin

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class],version = 1)
abstract class TaskDB : RoomDatabase(){
    abstract fun taskDAO() : TaskDAO

    companion object{
        fun getTaskDataBase(application: Application): TaskDB{
            val taskDB = Room.databaseBuilder(application,TaskDB::class.java,"TaskDB")
               // .allowMainThreadQueries()
                .build()
            return taskDB
        }
    }
}