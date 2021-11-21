package com.myapp.workmanagersample.data.local.database

import com.myapp.workmanagersample.data.local.database.dao.CountMemoDao
import com.myapp.workmanagersample.data.local.database.entity.CountMemoEntity
import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * DB定義
 */
@Database(
    entities = [CountMemoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countMemoDao(): CountMemoDao
}
