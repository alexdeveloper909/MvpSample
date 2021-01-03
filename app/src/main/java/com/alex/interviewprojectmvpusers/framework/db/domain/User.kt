package com.alex.interviewprojectmvpusers.framework.db.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
        @PrimaryKey val id:String,
        val firstName:String,
        val secondName:String,
        val address:String,
        val birthDate:String,
        val email:String,
        val cell:String,
        val bigPhoto:String
)