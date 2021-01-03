package com.alex.interviewprojectmvpusers.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alex.interviewprojectmvpusers.framework.db.daos.UserDao
import com.alex.interviewprojectmvpusers.framework.db.domain.User


@Database(
        entities = [User::class],
        version = 1,
        exportSchema = false
)
abstract class UserDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao
}