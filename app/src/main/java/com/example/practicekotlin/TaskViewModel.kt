package com.example.practicekotlin

import android.app.Application
import android.util.Log
import androidx.lifecycle.*

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = "Test"
    var taskList: MutableLiveData<MutableList<Task>> = MutableLiveData(mutableListOf())
    val taskRepository = TaskRepository(application)

    fun getTaskLis(): MutableLiveData<MutableList<Task>> {
        taskList.value?.addAll(taskRepository.getAllTask())
       // taskList.postValue(taskList.value)
        return taskList
    }

    fun addTask(task : Task){
        taskRepository.add(task)
        taskList.value?.add(task)
        taskList.postValue(taskList.value)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun refreshList(){
        taskList.value?.addAll(taskRepository.getAllTask())
        taskList.postValue(taskList.value)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "TaskViewModel onCleared: ")
    }
}