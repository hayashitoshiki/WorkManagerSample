package com.myapp.workmanagersample.data.repository

import com.myapp.workmanagersample.data.local.database.dao.CountMemoDao
import com.myapp.workmanagersample.data.local.database.entity.CountMemoEntity
import com.myapp.workmanagersample.data.local.preferences.PreferenceKey
import com.myapp.workmanagersample.data.local.preferences.PreferenceManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalSampleRepositoryImpl @Inject constructor(
    private val preferenceManager: PreferenceManager,
    private val countMemoDao: CountMemoDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): LocalSampleRepository {

    override suspend fun getData() = withContext(ioDispatcher) {
        countMemoDao.getAll()
    }

    override suspend fun deleteData() = withContext(ioDispatcher) {
        countMemoDao.deleteAll()
    }

    override suspend fun addData(count: Int) = withContext(ioDispatcher) {
        val entity = CountMemoEntity(0, count)
        countMemoDao.insert(entity)
    }

    override suspend fun updateCounter() {
        val count = preferenceManager.getInt(PreferenceKey.IntKey.ASYNC_COUNT)
        preferenceManager.setInt(PreferenceKey.IntKey.ASYNC_COUNT, count + 1)
    }

    override suspend fun getAsyncCount(): Int {
        return preferenceManager.getInt(PreferenceKey.IntKey.ASYNC_COUNT)
    }

}