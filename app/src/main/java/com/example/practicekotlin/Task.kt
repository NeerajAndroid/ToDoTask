package com.example.practicekotlin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(@PrimaryKey val uid : Long,
                @ColumnInfo(name = "title") val title : String,
                @ColumnInfo(name = "Description") val description : String)
