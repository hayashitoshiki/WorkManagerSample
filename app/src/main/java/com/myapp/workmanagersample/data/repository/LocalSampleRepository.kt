package com.myapp.workmanagersample.data.repository

import com.myapp.workmanagersample.data.local.database.entity.CountMemoEntity

interface LocalSampleRepository {

    suspend fun getData() : List<CountMemoEntity>

    suspend fun addData(count: Int)

    suspend fun deleteData()

    suspend fun updateCounter()

    suspend fun getAsyncCount() : Int

}