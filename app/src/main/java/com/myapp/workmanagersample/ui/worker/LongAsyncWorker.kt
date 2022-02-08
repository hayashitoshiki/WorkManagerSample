package com.myapp.workmanagersample.ui.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.myapp.workmanagersample.domain.usecase.BackgroundSampleUseCase
import com.myapp.workmanagersample.ui.util.PushManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

/**
 * 10分以上の長時間の非同期Workerサンプル
 *
 * @constructor
 * TODO
 *
 * @param context
 * @param workerParams
 */
@HiltWorker
class LongAsyncWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val backgroundSampleUseCase: BackgroundSampleUseCase,
    private val pushManager: PushManager
): CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        setForeground(createForegroundInfo())
        Log.d("CountAsyncWorker", "--- 開始 ---")
        backgroundSampleUseCase.doLongAsyncBackground()
        Log.d("CountAsyncWorker", "--- 終了 ---")
        return Result.success()
    }

    private fun createForegroundInfo(): ForegroundInfo {
       val notificationId = 1001
       return ForegroundInfo(notificationId, pushManager.createForegroundInfoNotification())
    }
}
