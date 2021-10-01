package com.example.practicekotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.neeraj.todo.task.databinding.ActivityMainBinding
import com.neeraj.todo.task.R


class MainActivity : AppCompatActivity() {
    private val TAG = "Test"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, TaskListFragment(),"TaskList").addToBackStack(null)
            .commit()
        Log.i(TAG, "MainActivity onCreate: ")
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 0){
            supportFragmentManager.popBackStack()
        }else{
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "MainActivity onDestroy: ")
    }
}