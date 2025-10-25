package com.ramazan.app.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramazan.app.R
import com.ramazan.app.TaskApplication
import com.ramazan.app.databinding.FragmentTaskListBinding
import com.ramazan.app.view.adapters.TaskAdapter
import com.ramazan.app.viewModel.TaskViewModel

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskListBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskListBinding.inflate(layoutInflater, container, false)
        taskViewModel = (requireActivity().application as TaskApplication).taskViewModel
        taskViewModel.tasks.observe(viewLifecycleOwner){ listTasks ->
            if (!listTasks.isNullOrEmpty()){
                with(binding.list) {
                    layoutManager = LinearLayoutManager(context)
                    adapter = TaskAdapter(
                        listTasks.filter { it.isCompleted == !taskViewModel.showActive },
                        requireActivity()
                    )
                }
                binding.btnShowCompletedTasks.text = if (taskViewModel.showActive) "Show Completed Tasks" else "Show Active Tasks"
                binding.btnShowCompletedTasks.setOnClickListener {
                    taskViewModel.showActive = !taskViewModel.showActive
                }
            }
        }
        taskViewModel.notifyMsg.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
        binding.addTask.setOnClickListener {
            taskViewModel.setCurrentTask(null)
            Navigation.findNavController(binding.root).navigate(R.id.action_taskFragment2_to_addUpdateTaskFragment)
        }
        return binding.root
    }
}