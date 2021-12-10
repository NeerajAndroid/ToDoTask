package com.example.practicekotlin

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application,var taskRepository: TaskRepository) : AndroidViewModel(application) {
    private val TAG = "Test"
    var taskList: MutableLiveData<MutableList<Task>> = MutableLiveData(mutableListOf())
  //  val taskRepository = TaskRepository(application)

    fun getTaskLis(): MutableLiveData<MutableList<Task>> {
        viewModelScope.launch(Dispatchers.IO) {
            var list = taskRepository.getAllTask();
            viewModelScope.launch(Dispatchers.Main) { taskList.value?.addAll(list)
            taskList.postValue(taskList.value)}
        }
        return taskList
    }

    fun addTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.add(task)
        }
        taskList.value?.add(task)
        taskList.postValue(taskList.value)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun refreshList() {
        // taskList.value?.addAll(taskRepository.getAllTask())
        // taskList.postValue(taskList.value)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "TaskViewModel onCleared: ")
    }
}