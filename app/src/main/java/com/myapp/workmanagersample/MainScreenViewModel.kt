package com.myapp.workmanagersample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.work.*
import com.myapp.workmanagersample.ui.worker.CountAsyncWorker
import com.myapp.workmanagersample.ui.worker.CountWorker
import com.myapp.workmanagersample.ui.worker.LongAsyncWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val workManager: WorkManager): ViewModel() {

    /**
     * 下記の条件のWorkerを発火する
     *
     * ・状態：not suspend
     * ・連投：KEEP(前の処理がある場合発火しない）
     */
    fun startWorker() {
        Log.d("MainScreenViewModel", "startWorker --- 開始 ---")
        val request = OneTimeWorkRequest.Builder(CountWorker::class.java).build()
        workManager.enqueueUniqueWork(
            CountWorker.WORK_NAME,
            ExistingWorkPolicy.KEEP, request)
        Log.d("MainScreenViewModel", "startWorker --- 終了 ---")
    }

    /**
     * 下記の条件のWorkerを発火する
     *
     * ・状態：not suspend
     * ・連投：REPLACE(前の処理がある場合前の処理をキャンセルして発火）
     */
    fun startWorkerAndReplace() {
        Log.d("MainScreenViewModel", "startWorker --- 開始 ---")
        val request = OneTimeWorkRequest.Builder(CountWorker::class.java).build()
        workManager.enqueueUniqueWork(
            CountWorker.WORK_NAME,
            ExistingWorkPolicy.REPLACE, request)
        Log.d("MainScreenViewModel", "startWorker --- 終了 ---")
    }


    /**
     * 下記の条件のWorkerを発火する
     *
     * ・状態：suspend
     * ・連投：APPEND(前の処理終了後発火）
     */
    fun startAsyncWorkerAndAppend() {
        Log.d("MainScreenViewModel", "startAsyncWorker --- 開始 ---")
        val request = OneTimeWorkRequest.Builder(CountAsyncWorker::class.java).build()
        workManager.enqueueUniqueWork(CountAsyncWorker.WORK_NAME, ExistingWorkPolicy.APPEND, request)
        Log.d("MainScreenViewModel", "startAsyncWorker --- 終了 ---")
    }

    /**
     * 下記の条件のWorkerを発火する
     *
     * ・状態：suspend
     * ・連投：指定なし(前の処理が走っていても続けて発火）
     */
    fun startAsyncWorker() {
        Log.d("MainScreenViewModel", "startAsyncWorker --- 開始 ---")
        val uploadWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<CountAsyncWorker>().build()
        workManager.enqueue(uploadWorkRequest)
        Log.d("MainScreenViewModel", "startAsyncWorker --- 終了 ---")
    }

    /**
     * 下記の条件のWorkerを発火する
     *
     * ・状態：suspend
     * ・連投：指定なし(前の処理が走っていても続けて発火）
     */
    fun startLongAsyncWorker() {
        Log.d("MainScreenViewModel", "startLongAsyncWorker --- 開始 ---")
        val uploadWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<LongAsyncWorker>().build()
        workManager.enqueue(uploadWorkRequest)
        Log.d("MainScreenViewModel", "startLongAsyncWorker --- 終了 ---")
    }
}