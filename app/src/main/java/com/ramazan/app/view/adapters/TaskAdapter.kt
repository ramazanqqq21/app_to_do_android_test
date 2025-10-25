package com.ramazan.app.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ramazan.app.R
import com.ramazan.app.TaskApplication
import com.ramazan.app.databinding.FragmentTaskItemBinding
import com.ramazan.app.model.tasks.TaskModel

class TaskAdapter(
    private val values: List<TaskModel>,
    private val requireActivity: FragmentActivity
) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentTaskItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        with(holder){
            nameView.text = item.name
            descriptionView.text = item.description
            timeView.text = item.timeCreated
            imgBtnDeleteTask.setOnClickListener {
                taskViewModel.deleteTask(item.id!!)
            }
            if(item.isCompleted!!){
                chbxSetCompleted.visibility = View.GONE
            }else{
                containerTask.setOnClickListener {
                    taskViewModel.setCurrentTask(item)
                    Navigation.findNavController(containerTask).navigate(R.id.action_taskFragment2_to_addUpdateTaskFragment)
                }
                chbxSetCompleted.setOnClickListener {
                    taskViewModel.completeTask(item.id!!)
                }
            }
        }
    }

    override fun getItemCount(): Int = values.size
    inner class ViewHolder(binding: FragmentTaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val chbxSetCompleted: CheckBox = binding.chbxSetCompleted
        val nameView: TextView = binding.content
        val descriptionView: TextView = binding.description
        val timeView:TextView = binding.time
        val containerTask:LinearLayout = binding.taskContainer
        val imgBtnDeleteTask:ImageButton = binding.imgBtnDeleteTasks
        val taskViewModel = (requireActivity.application as TaskApplication).taskViewModel
    }

}