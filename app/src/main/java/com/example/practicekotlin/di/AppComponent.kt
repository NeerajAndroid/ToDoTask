package com.example.practicekotlin.di

import com.example.practicekotlin.MainActivity
import com.example.practicekotlin.Mobile
import com.example.practicekotlin.Task
import com.example.practicekotlin.TaskListFragment
import dagger.Component

@Component(modules = [TaskModule::class])
interface AppComponent {
    /*@Provides
    fun getAppContext(): Context

    @Provides
    fun getTaskRepository():TaskRepository
*/

    fun getDummyTask(): Task
    fun getMobile(): Mobile

    fun inject(taskListFragment: TaskListFragment)
    fun inject(mainActivity: MainActivity)
}