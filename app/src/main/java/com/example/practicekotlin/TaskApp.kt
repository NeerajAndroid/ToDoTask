package com.example.practicekotlin

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.practicekotlin.di.AppComponent
import com.example.practicekotlin.di.DaggerAppComponent
import com.example.practicekotlin.di.TaskModule

class TaskApp : Application() {
    private  val TAG = "TaskApp"
    lateinit var appComponent : AppComponent
    override fun onCreate() {
        super.onCreate()
      // appComponent =  DaggerAppComponent.create()
       appComponent = DaggerAppComponent.builder().taskModule(TaskModule(this)).build()
        Log.d(TAG, "onCreate: ")
    }

    private fun initDagger(): AppComponent =
        DaggerAppComponent.builder()
            .build()
}