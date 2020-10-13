package com.polish.usedaggerhilt.data.localdatasource.blogdatabaserepo

import androidx.lifecycle.LiveData
import com.polish.usedaggerhilt.data.localdatasource.POSTitemDao
import com.polish.usedaggerhilt.data.localdatasource.PostCacheEntity
import javax.inject.Inject

/**
 * this @Inject constructor on the "BlogRepositoryImpl" inform daggerHilt on how to generate the dependency
 * and I passed an object of this class to the PostViewModel
 */
class BlogRepositoryImpl @Inject constructor(
    val posTitemDao: POSTitemDao
):BlogRepository {
     override suspend fun addPost(postEntity: PostCacheEntity) {
        posTitemDao.insert(postEntity)
    }

    override suspend fun getPostItem(): List<PostCacheEntity> {
        return posTitemDao.getPosts()
    }

    override fun getPostItemLiveData(): LiveData<List<PostCacheEntity>> {
        return posTitemDao.getPostsLiveData()
    }
}