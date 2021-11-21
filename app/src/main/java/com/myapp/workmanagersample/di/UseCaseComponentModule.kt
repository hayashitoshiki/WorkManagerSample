package com.myapp.workmanagersample.di

import com.myapp.workmanagersample.domain.usecase.BackgroundSampleUseCase
import com.myapp.workmanagersample.domain.usecase.BackgroundSampleUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseComponentModule {

    @Binds
    abstract fun bindBackgroundSampleUseCase(
        backgroundSampleUseCaseImpl: BackgroundSampleUseCaseImpl): BackgroundSampleUseCase
}