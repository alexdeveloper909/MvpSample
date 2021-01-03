package com.alex.interviewprojectmvpusers.di

import android.content.Context
import com.alex.interviewprojectmvpusers.framework.network.ApiClient
import com.alex.interviewprojectmvpusers.framework.network.ResponseHandler
import com.alex.interviewprojectmvpusers.framework.repository.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideApiClient(): ApiClient {
        return ApiClient
    }

    @Provides
    fun provideResponseHandler() : ResponseHandler = ResponseHandler()

    @Provides
    fun provideApiRepository(
        apiClient: ApiClient,
        responseHandler: ResponseHandler,
        @ApplicationContext context: Context
    ): ApiRepository {
        return ApiRepository(apiClient, responseHandler, context)
    }
}