package com.polish.usedaggerhilt.di

import android.content.Context
import androidx.room.Room
import com.polish.usedaggerhilt.data.localdatasource.BlogDatabase
import com.polish.usedaggerhilt.data.localdatasource.POSTitemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun providesBlogDb(@ApplicationContext context: Context):BlogDatabase {
        return Room.databaseBuilder(
            context,
            BlogDatabase::class.java,
            BlogDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePostItemDao(blogDatabase: BlogDatabase):POSTitemDao{
        return blogDatabase.postDao()
    }

}