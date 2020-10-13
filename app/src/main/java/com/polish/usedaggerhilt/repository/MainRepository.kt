package com.polish.usedaggerhilt.repository

import android.util.Log
import com.polish.usedaggerhilt.data.api.NetworkMpper
import com.polish.usedaggerhilt.data.api.PostAPI
import com.polish.usedaggerhilt.data.localdatasource.CacheMapper
import com.polish.usedaggerhilt.data.localdatasource.POSTitemDao
import com.polish.usedaggerhilt.model.POSTItem
import com.polish.usedaggerhilt.util.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository constructor(
    private val postItemDao:POSTitemDao,
    private val postAPI: PostAPI,
    private val cacheMapper: CacheMapper,
    private val networkMapper:NetworkMpper
) {

    val TAG = "MAIN_REPOSITORY"

    /**
     *
     */



    /**
     * get the post
     */

    suspend fun getMyPost():DataState<List<POSTItem>>{
        return withContext(Dispatchers.IO){
            try {
                val networkPost = postAPI.getPosts()
                /**
                 * to insert it into my database
                 * by first converting to the domain object using network mapper
                 */
                val posts = networkMapper.mapFromEntityList(networkPost)
//                Log.d(TAG, "result: ${posts}")
                for (post in posts){
                    postItemDao.insert(cacheMapper.mapToEntity(post))
                }
                /**
                 * I am retrieving a list of post from my database
                 */
                val savedPostsInDatabase = postItemDao.getPosts()
                DataState.Success(cacheMapper.mapFromEntityList(savedPostsInDatabase))
            } catch (e:Exception){
                DataState.Error(e)
            }
        }
    }

}