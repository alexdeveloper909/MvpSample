package com.alex.interviewprojectmvpusers.di

import com.alex.interviewprojectmvpusers.framework.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideUsersRepository():UsersRepository{
        return UsersRepository
    }
}