package com.polish.usedaggerhilt.data.localdatasource

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface POSTitemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(postEntity: PostCacheEntity)

    @Query("SELECT * FROM posts")
    suspend fun getPosts():List<PostCacheEntity>

    @Transaction
    @Query("SELECT * FROM posts")
    fun getPostsLiveData():LiveData<List<PostCacheEntity>>

}