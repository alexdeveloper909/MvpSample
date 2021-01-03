package com.alex.interviewprojectmvpusers.framework.network.domain

data class Location(
    val street: Street,
    val city:String,
    val state:String,
    val postcode:String,
    val coordinates:Coordinates,
    val timeZone:TimeZone
)