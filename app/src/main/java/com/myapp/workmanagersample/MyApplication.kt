package com.myapp.workmanagersample

import android.app.Application
import androidx.room.Room
import androidx.work.*
import com.myapp.workmanagersample.data.local.database.AppDatabase
import com.myapp.workmanagersample.ui.worker.CustomWorkerFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: CustomWorkerFactory

    companion object {
        lateinit var shared: MyApplication
        lateinit var database: AppDatabase
    }

    init {
        shared = this
    }


    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext, AppDatabase::class.java, "app_database"
        ).build()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }

}