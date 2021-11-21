package com.myapp.workmanagersample.di

import com.myapp.workmanagersample.data.repository.LocalSampleRepository
import com.myapp.workmanagersample.data.repository.LocalSampleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Repository 依存性注入
 *
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryComponentModule {

    @Binds
    abstract fun bindLocalSampleRepository(impl: LocalSampleRepositoryImpl): LocalSampleRepository

}
