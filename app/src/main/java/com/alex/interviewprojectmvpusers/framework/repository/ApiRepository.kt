package com.alex.interviewprojectmvpusers.framework.repository

import android.content.Context
import com.alex.interviewprojectmvpusers.framework.network.domain.NetResult
import com.alex.interviewprojectmvpusers.framework.network.ApiClient
import com.alex.interviewprojectmvpusers.framework.network.Resource
import com.alex.interviewprojectmvpusers.framework.network.ResponseHandler
import com.alex.interviewprojectmvpusers.framework.repository.contracts.ApiRepositoryContract
import java.lang.Exception

class ApiRepository(
    private val apiClient: ApiClient,
    private val responseHandler: ResponseHandler,
    private val context: Context
) : ApiRepositoryContract {
    override suspend fun fetchUserData(): Resource<NetResult> {
        return try{
            responseHandler.handleSuccess(apiClient.getApiService(context).getCitiesData())
        }catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}