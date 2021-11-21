package com.myapp.workmanagersample.ui.worker

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.myapp.workmanagersample.domain.usecase.BackgroundSampleUseCase
import javax.inject.Inject

/**
 * Workerクラス生成用クラス
 *
 * ここのクラスでWorkerクラスをまとめて生成
 * Workerクラスで使用するクラスをここでInject
 * @property backgroundSampleUseCase
 */
class CustomWorkerFactory @Inject constructor(
    private val backgroundSampleUseCase: BackgroundSampleUseCase
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
            // TODO : Workerが増える毎にここに追加していく
            // その他
            else -> null
        }
    }
}