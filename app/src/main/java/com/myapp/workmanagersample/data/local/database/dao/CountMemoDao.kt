package com.myapp.workmanagersample.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.myapp.workmanagersample.data.local.database.entity.CountMemoEntity

@Dao
interface CountMemoDao {

    @Insert
    suspend fun insert(countMemoEntity: CountMemoEntity)

    @Query("SELECT * FROM count_memo")
    suspend fun getAll(): List<CountMemoEntity>

    @Query("DELETE FROM count_memo")
    suspend fun deleteAll()
}