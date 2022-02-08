package com.myapp.workmanagersample.di

import android.content.Context
import androidx.work.WorkManager
import com.myapp.workmanagersample.ui.util.PushManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideWorkManager(
        @ApplicationContext context: Context
    ) = WorkManager.getInstance(context)

    @Provides
    fun providePushManager(
        @ApplicationContext context: Context
    ) = PushManager(context)

}
