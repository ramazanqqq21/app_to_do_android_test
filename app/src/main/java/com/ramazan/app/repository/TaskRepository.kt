package com.ramazan.app.repository

import com.ramazan.app.model.MyCustomCallback
import com.ramazan.app.model.tasks.TaskInterface
import com.ramazan.app.model.tasks.TaskModel

class TaskRepository(private val taskInterface: TaskInterface) {
    fun getTaskById(id: String, callback: MyCustomCallback<TaskModel>) {
        taskInterface.getTaskById(id, callback)
    }

    fun getTasks(callback: MyCustomCallback<TaskModel>){
        taskInterface.getTasks(callback)
    }

    fun addTask(task: TaskModel, callback: MyCustomCallback<TaskModel>) {
        taskInterface.addTask(task, callback)
    }

    fun updateTask(task: TaskModel, callback: MyCustomCallback<TaskModel>) {
        taskInterface.updateTask(task, callback)
    }

    fun deleteTask(id: String, callback: MyCustomCallback<TaskModel>) {
        taskInterface.deleteTask(id, callback)
    }

    fun completeTask(id:String, callback: MyCustomCallback<TaskModel>){
        taskInterface.completeTask(id, callback)
    }
    fun syncData(listTask:List<TaskModel>, callback: MyCustomCallback<TaskModel>){
        taskInterface.syncData(listTask, callback)
    }
}