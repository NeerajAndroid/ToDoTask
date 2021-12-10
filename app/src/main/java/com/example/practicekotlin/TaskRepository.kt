package com.example.practicekotlin

import android.app.Application

class TaskRepository(val application: Application) {

     fun getAllTask() : List<Task>{
       return TaskDB.getTaskDataBase(application).taskDAO().getAll()
    }

    fun add(task: Task){
        TaskDB.getTaskDataBase(application).taskDAO().insertInto(task)
    }
}