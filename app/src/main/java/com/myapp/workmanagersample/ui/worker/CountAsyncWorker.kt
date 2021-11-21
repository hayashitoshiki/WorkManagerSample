package com.myapp.workmanagersample.ui.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.myapp.workmanagersample.domain.usecase.BackgroundSampleUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import javax.inject.Inject

/**
 * 非同期Workerサンプル
 *
 * @constructor
 * TODO
 *
 * @param context
 * @param workerParams
 */
@HiltWorker
class CountAsyncWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val backgroundSampleUseCase: BackgroundSampleUseCase
    ): CoroutineWorker(context, workerParams) {

    companion object {
        const val WORK_NAME = "CountAsyncWorker"
    }

    override suspend fun doWork(): Result {
        Log.d("CountAsyncWorker", "--- 開始 ---")
        backgroundSampleUseCase.doAsyncBackground()
        Log.d("CountAsyncWorker", "--- 終了 ---")
        return Result.success()
    }
}
