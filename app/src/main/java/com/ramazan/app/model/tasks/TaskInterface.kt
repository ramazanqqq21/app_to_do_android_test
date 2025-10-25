package com.ramazan.app.model.tasks

import com.ramazan.app.model.MyCustomCallback

interface TaskInterface {
    //Получение задачи по идентификатору id
    fun getTaskById(id:String, callback: MyCustomCallback<TaskModel>)
    //Получение всех задач.
    fun getTasks(callback: MyCustomCallback<TaskModel>)
    //Добавление новой задачи.
    fun addTask(task:TaskModel, callback: MyCustomCallback<TaskModel>)
    //Обновление существующей задачи.
    fun updateTask(task: TaskModel, callback: MyCustomCallback<TaskModel>)
    //Удаление задачи по id.
    fun deleteTask(id:String, callback: MyCustomCallback<TaskModel>)
    //Отмечает задачу как завершённую по id.
    fun completeTask(id: String, callback: MyCustomCallback<TaskModel>)
    //Синхронизация данных задач.
    fun syncData(listTasks:List<TaskModel>, callback: MyCustomCallback<TaskModel>)
}