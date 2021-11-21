package com.myapp.workmanagersample

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.myapp.workmanagersample.ui.CountWorker

class MainScreenViewModel: ViewModel() {
    fun startWorker(context: Context) {
        val uploadWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<CountWorker>()
                .build()
        WorkManager
            .getInstance(context)
            .enqueue(uploadWorkRequest)
    }
}