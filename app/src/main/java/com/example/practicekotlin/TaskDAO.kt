package com.example.practicekotlin

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDAO {

    @Insert
    fun insertInto(task: Task)

    @Query("Select * from Task")
    fun getAll() : List<Task>

    @Delete
    fun remove(task: Task)
}