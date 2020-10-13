package com.polish.usedaggerhilt.di

import com.polish.usedaggerhilt.data.api.NetworkMpper
import com.polish.usedaggerhilt.data.api.PostAPI
import com.polish.usedaggerhilt.data.localdatasource.CacheMapper
import com.polish.usedaggerhilt.data.localdatasource.POSTitemDao
import com.polish.usedaggerhilt.data.localdatasource.blogdatabaserepo.BlogRepository
import com.polish.usedaggerhilt.data.localdatasource.blogdatabaserepo.BlogRepositoryImpl
import com.polish.usedaggerhilt.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun providesMainRepository(
        posTitemDao: POSTitemDao,
        postAPI: PostAPI,
        cacheMapper: CacheMapper,
        networkMpper: NetworkMpper
    ):MainRepository{
        return MainRepository(posTitemDao, postAPI, cacheMapper, networkMpper)
    }
    
    @Singleton
    @Provides
    fun provideBlogDatabaseRepository(
        posTitemDao: POSTitemDao
    ):BlogRepository{
        return BlogRepositoryImpl(posTitemDao)
    }

}