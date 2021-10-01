package com.example.practicekotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neeraj.todo.task.databinding.TaskItemBinding

class TaskAdapter(var list: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(TaskItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        var task = list[position]
        holder.taskItemBinding.task = task
    }

    class TaskViewHolder(var taskItemBinding: TaskItemBinding) :
        RecyclerView.ViewHolder(taskItemBinding.root) {
    }
}