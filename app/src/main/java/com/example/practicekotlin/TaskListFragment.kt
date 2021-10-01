package com.example.practicekotlin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.neeraj.todo.task.databinding.FragmentTaskListBinding
import com.neeraj.todo.task.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TaskListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TaskListFragment : Fragment() {
    private  val TAG = "Test"
    lateinit var mainActivity: MainActivity
    lateinit var viewModel: TaskViewModel
    lateinit var binding : FragmentTaskListBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskListBinding.inflate(layoutInflater)
        binding.floatingActionButton.setOnClickListener {
            mainActivity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TaskDetailFragment(), "TaskDetail")
                .addToBackStack(null)
                .commit()
        }
        initList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun initList(){
        viewModel = ViewModelProvider(mainActivity).get(TaskViewModel::class.java)
        Log.i(TAG, "initList: ${viewModel.hashCode()}")
        viewModel.getTaskLis().observe(mainActivity,  { taskList ->
            if(taskList.isEmpty()){
                binding.tvNoItems.visibility = View.VISIBLE
                binding.rvTaskList.visibility = View.GONE
                binding.tvNoItems.text="No Task for Today"
            }else{
                binding.rvTaskList.visibility = View.VISIBLE
                binding.tvNoItems.visibility = View.GONE
                binding.rvTaskList.layoutManager = LinearLayoutManager(binding.rvTaskList.context)
                binding.rvTaskList.adapter = TaskAdapter(taskList)
            }

        })

        //CoroutineScope(IO)
    }
}