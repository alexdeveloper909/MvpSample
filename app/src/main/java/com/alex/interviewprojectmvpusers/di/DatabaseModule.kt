package com.alex.interviewprojectmvpusers.di

import android.content.Context
import androidx.room.Room
import com.alex.interviewprojectmvpusers.framework.db.UserDatabase
import com.alex.interviewprojectmvpusers.framework.db.daos.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : UserDatabase {
        return Room.databaseBuilder(
                context,
                UserDatabase::class.java,
                "com.alex.interviewproject.db"
        ).fallbackToDestructiveMigration().allowMainThreadQueries() .build()
    }

    @Provides
    fun provideCityDao(database: UserDatabase) : UserDao {
        return database.userDao()
    }

}