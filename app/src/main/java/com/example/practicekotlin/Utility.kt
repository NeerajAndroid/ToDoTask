package com.example.practicekotlin

import java.util.*

class Utility {
    companion object{
        fun toUpperCase(text : String) : String {
            return text.uppercase(Locale.getDefault())
        }
    }

}