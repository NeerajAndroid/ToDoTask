package com.example.practicekotlin

import android.content.Context
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.neeraj.todo.task.R
import com.neeraj.todo.task.databinding.FragmentTaskDetailBinding
import kotlin.random.Random


/**
 * A simple [Fragment] subclass.
 * Use the [TaskDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TaskDetailFragment : Fragment() {
    lateinit var viewModel: TaskViewModel
    lateinit var activity: MainActivity
    private lateinit var binding: FragmentTaskDetailBinding
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskDetailBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(activity).get(TaskViewModel::class.java)
        binding.btnSave.setOnClickListener {
            viewModel.addTask(
                Task(
                    System.currentTimeMillis(),
                    binding.etTitle.text.toString(),
                    binding.etDescription.text.toString()
                )
            )
            activity.supportFragmentManager.popBackStack()
        }
        return binding.root
    }
}