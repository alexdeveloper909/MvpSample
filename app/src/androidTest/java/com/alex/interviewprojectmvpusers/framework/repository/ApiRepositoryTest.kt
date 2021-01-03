package com.alex.interviewprojectmvpusers.framework.repository

import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.LargeTest
import com.alex.interviewprojectmvpusers.framework.network.ApiClient
import com.alex.interviewprojectmvpusers.framework.network.ResponseHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

@ExperimentalCoroutinesApi
@LargeTest
class ApiRepositoryTest {
    lateinit var apiClient: ApiClient
    lateinit var responseHandler: ResponseHandler
    lateinit var apiRepository: ApiRepository

    @Before
    fun setUp() {
        apiClient = ApiClient
        responseHandler = ResponseHandler()
        apiRepository = ApiRepository(apiClient,responseHandler, ApplicationProvider.getApplicationContext())
    }

    @LargeTest
    @Test
    fun fetchUserData() = runBlocking{
        val list = apiRepository.fetchUserData()


        val actual = list.data!!.results.first().email
        val name = "Kyiv"
        assertEquals(name,actual)
    }
}