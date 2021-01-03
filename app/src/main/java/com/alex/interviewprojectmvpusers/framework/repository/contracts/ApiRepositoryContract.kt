package com.alex.interviewprojectmvpusers.framework.repository.contracts

import com.alex.interviewprojectmvpusers.framework.network.domain.NetResult
import com.alex.interviewprojectmvpusers.framework.network.Resource

interface ApiRepositoryContract {
    suspend fun fetchUserData(): Resource<NetResult>
}