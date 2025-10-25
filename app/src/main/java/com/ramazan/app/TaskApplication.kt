package com.ramazan.app

import android.app.Application
import com.ramazan.app.viewModel.TaskViewModel
import io.paperdb.Paper

class TaskApplication : Application() {
    val taskViewModel = TaskViewModel()

    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
    }
}