package com.myapp.workmanagersample.domain.usecase

import android.util.Log
import com.myapp.workmanagersample.data.repository.LocalSampleRepository
import javax.inject.Inject

class BackgroundSampleUseCaseImpl  @Inject constructor(
    private val localSampleRepository: LocalSampleRepository
) : BackgroundSampleUseCase {

    override fun doBackground() {
       Log.d("BackgroundSampleUseCaseImpl", "doBackground --- start ---")
        for (i in 1..1000000000) {
            if (i % 50000000 == 0) {
                Log.d("BackgroundSampleUseCaseImpl", "doBackground count = " + i)
            }
        }
        Log.d("BackgroundSampleUseCaseImpl", "doBackground --- end ---")
    }

    override suspend fun doAsyncBackground() {
        localSampleRepository.updateCounter()
        val count = localSampleRepository.getAsyncCount()
        Log.d("BackgroundSampleUseCaseImpl", "doAsyncBackground --- start ---")
        Log.d("BackgroundSampleUseCaseImpl", "doAsyncBackground count = $count")
        val list1 = localSampleRepository.getData()
        Log.d("BackgroundSampleUseCaseImpl", "doAsyncBackground 保存データ = $list1")
        for (i in 1..1000000000) {
            if (i % 50000000 == 0) {
                localSampleRepository.addData(i)
                Log.d("BackgroundSampleUseCaseImpl", "doAsyncBackground count = $i")
            }
        }
        val list2 = localSampleRepository.getData()
        Log.d("BackgroundSampleUseCaseImpl", "doAsyncBackground 保存データ = $list2")
        localSampleRepository.deleteData()
        Log.d("BackgroundSampleUseCaseImpl", " doAsyncBackground --- end ---")
    }
}