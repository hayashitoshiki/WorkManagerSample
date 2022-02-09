package com.myapp.workmanagersample.domain.usecase

interface BackgroundSampleUseCase {

    fun doBackground()

    suspend fun doAsyncBackground()

    suspend fun doLongAsyncBackground()

    suspend fun doNotificationUpdateBackground()

}