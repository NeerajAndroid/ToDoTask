package com.example.practicekotlin

import android.app.Application
import android.content.Context

class TaskApp : Application() {
    val dataBase by lazy { TaskDB.getTaskDataBase(this) }
}