package com.example.practicekotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekotlin.play.PlayGame
import com.neeraj.todo.task.databinding.ActivityMainBinding
import com.neeraj.todo.task.R
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    private val TAG = "Test"
    @Inject lateinit var task : Task
    @Inject lateinit var mobile: Mobile
    @Inject lateinit var taskRepository: TaskRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, TaskListFragment(),"TaskList").addToBackStack(null)
            .commit()
        Log.i(TAG, "MainActivity onCreate: ")
       // TaskApp().appComponent.inject(this)

        (application as TaskApp).appComponent.inject(this)
        Log.d(TAG, "onCreate: $task.")
        Log.d(TAG, "onCreate: mobile $mobile")
        Log.d(TAG, "onCreate: mobile $taskRepository")

        
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

    fun play(){
        var playGame = object : PlayGame {
            override fun playGame() {
                play()
            }
        }
    }
}