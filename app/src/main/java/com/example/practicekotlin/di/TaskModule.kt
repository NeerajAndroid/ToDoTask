package com.example.practicekotlin.di

import android.app.Application
import com.example.practicekotlin.Task
import com.example.practicekotlin.TaskRepository
import dagger.Module
import dagger.Provides

@Module
class TaskModule(var application: Application) {

    @Provides
    fun getDummyTask(): Task {
        return Task(123, "Test Dagger", "Test dagger description")
    }

    @Provides
    fun getTask(): Application{
        return application
    }
    @Provides
    fun getTaskRepository(): TaskRepository {
        return TaskRepository(getTask())
    }
}