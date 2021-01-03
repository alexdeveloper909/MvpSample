package com.alex.interviewprojectmvpusers.framework.network.domain

import com.google.gson.annotations.SerializedName

data class NetResult(
    @SerializedName("results")
    val results:List<Person>,
    @SerializedName("info")
    val info:Info
)