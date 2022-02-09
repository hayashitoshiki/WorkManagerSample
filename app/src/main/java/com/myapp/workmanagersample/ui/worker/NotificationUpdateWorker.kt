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
import kotlinx.coroutines.delay


/**
 * 10分以上の長時間でかつ、通知が更新される非同期Workerサンプル
 *
 * @constructor
 * TODO
 *
 * @param context
 * @param workerParams
 */
@HiltWorker
class NotificationUpdateWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val backgroundSampleUseCase: BackgroundSampleUseCase,
    private val pushManager: PushManager
): CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        createForegroundInfo()
        Log.d("NotificationUpdateWorker", "--- 開始 ---")
        backgroundSampleUseCase.doNotificationUpdateBackground()
        Log.d("NotificationUpdateWorker", "--- 終了 ---")
        return Result.success()
    }

    private suspend fun createForegroundInfo() {
        val notificationId = 1002
        val foregroundInfoInit = ForegroundInfo(notificationId, pushManager.createAsyncForegroundInfoNotification("0"))
        setForegroundAsync(foregroundInfoInit)
        // 30秒ごと通知を更新
        for (i in 1..40) {
            delay(30000)
            val count = (i.toDouble() / 2).toString()
            val foregroundInfo = ForegroundInfo(notificationId, pushManager.createAsyncForegroundInfoNotification(count))
            setForegroundAsync(foregroundInfo)
            Log.d("BackgroundSampleUseCaseImpl", "doLongAsyncBackground " + count + "分経過")
        }
    }
}
