package com.myapp.workmanagersample.ui.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.myapp.workmanagersample.domain.usecase.BackgroundSampleUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import javax.inject.Inject

/**
 * 同期Workerサンプル
 *
 * @constructor
 * TODO
 *
 * @param context
 * @param workerParams
 */
@HiltWorker
class CountWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val backgroundSampleUseCase: BackgroundSampleUseCase
):
    Worker(context, workerParams) {

    companion object {
        const val WORK_NAME = "CustomWorkerFactory"
    }

    override fun doWork(): Result {
        Log.d("CountWorker", "--- 開始 ---")
        backgroundSampleUseCase.doBackground()
        Log.d("CountWorker", "--- 終了 ---")
        return Result.success()
    }
}
