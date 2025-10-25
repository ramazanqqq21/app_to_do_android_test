package com.ramazan.app.model.tasks

import com.ramazan.app.model.MyCustomCallback

interface TaskInterface {
    fun getTaskById(id:String, callback: MyCustomCallback<TaskModel>)
    fun getTasks(callback: MyCustomCallback<TaskModel>)
    fun addTask(task:TaskModel, callback: MyCustomCallback<TaskModel>)
    fun updateTask(task: TaskModel, callback: MyCustomCallback<TaskModel>)
    fun deleteTask(id:String, callback: MyCustomCallback<TaskModel>)
    fun completeTask(id: String, callback: MyCustomCallback<TaskModel>)
    fun syncData(listTasks:List<TaskModel>, callback: MyCustomCallback<TaskModel>)
}