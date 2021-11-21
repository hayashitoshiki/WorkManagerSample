package com.myapp.workmanagersample.di

import android.content.Context
import androidx.room.Room
import com.myapp.workmanagersample.data.local.database.AppDatabase
import com.myapp.workmanagersample.data.local.database.dao.CountMemoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DbComponentModule {

    // Database
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext, AppDatabase::class.java, "app_database"
        ).build()
    }

    // Dao
    @Provides
    @Singleton
    fun provideConstitutionDao(db: AppDatabase): CountMemoDao {
        return db.countMemoDao()
    }


    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}
