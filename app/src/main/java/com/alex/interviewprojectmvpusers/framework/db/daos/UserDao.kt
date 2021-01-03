package com.alex.interviewprojectmvpusers.framework.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alex.interviewprojectmvpusers.framework.db.domain.User

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * from user")
    suspend fun getAllUsers() : List<User>

    @Query("SELECT * from user WHERE id = :id LIMIT 1")
    suspend fun getUserById(id:String) : User
}