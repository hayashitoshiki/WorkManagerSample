package com.myapp.workmanagersample.ui

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.myapp.workmanagersample.domain.usecase.BackgroundSampleUseCaseImpl

class CountWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    private val backgroundSampleUseCase = BackgroundSampleUseCaseImpl()
    override fun doWork(): Result {
        backgroundSampleUseCase.doBackground()
        Log.d("BackgroundSampleUseCaseImpl", "--- 終了 ---")
        return Result.success()
    }
}
