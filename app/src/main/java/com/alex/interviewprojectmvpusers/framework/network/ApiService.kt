package com.alex.interviewprojectmvpusers.framework.network

import com.alex.interviewprojectmvpusers.framework.network.domain.NetResult
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.FETCH_CITIES)
    suspend fun getCitiesData() : NetResult
}