package com.myapp.workmanagersample.ui.worker

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.myapp.workmanagersample.domain.usecase.BackgroundSampleUseCase
import com.myapp.workmanagersample.ui.util.PushManager
import javax.inject.Inject

/**
 * Workerクラス生成用クラス
 *
 * ここのクラスでWorkerクラスをまとめて生成
 * Workerクラスで使用するクラスをここでInject
 * @property backgroundSampleUseCase
 */
class CustomWorkerFactory @Inject constructor(
    private val backgroundSampleUseCase: BackgroundSampleUseCase,
    private val pushManager: PushManager
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        Log.d("CountWorkerFactory", "判定 = $workerClassName")
        return when(workerClassName) {
            // CountWorker
            CountWorker::class.java.name -> {
                CountWorker(appContext, workerParameters, backgroundSampleUseCase)
            }
            // CountAsyncWorker
            CountAsyncWorker::class.java.name -> {
                CountAsyncWorker(appContext, workerParameters, backgroundSampleUseCase)
            }
            // LongAsyncWorker
            LongAsyncWorker::class.java.name -> {
                LongAsyncWorker(appContext, workerParameters, backgroundSampleUseCase, pushManager)
            }
            // NotificationUpdateWorker
            NotificationUpdateWorker::class.java.name -> {
                NotificationUpdateWorker(appContext, workerParameters, backgroundSampleUseCase, pushManager)
            }
            // TODO : Workerが増える毎にここに追加していく
            // その他
            else -> null
        }
    }
}