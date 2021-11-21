package com.myapp.workmanagersample.domain.usecase

import android.util.Log

class BackgroundSampleUseCaseImpl : BackgroundSampleUseCase {

    fun doBackground() {
       Log.d("BackgroundSampleUseCaseImpl", "--- start ---")
        for (i in 1..1000000000) {
            if (i % 50000000 == 0) {
                Log.d("BackgroundSampleUseCaseImpl", "count = " + i)
            }
        }
        Log.d("BackgroundSampleUseCaseImpl", "--- end ---")
    }
}