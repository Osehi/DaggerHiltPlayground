package com.polish.usedaggerhilt.data.localdatasource.blogdatabaserepo

import androidx.lifecycle.LiveData
import com.polish.usedaggerhilt.data.localdatasource.PostCacheEntity

interface BlogRepository {

   suspend fun addPost(postEntity: PostCacheEntity)

   suspend fun getPostItem():List<PostCacheEntity>

   fun getPostItemLiveData():LiveData<List<PostCacheEntity>>

}