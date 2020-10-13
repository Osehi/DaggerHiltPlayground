package com.polish.usedaggerhilt.data.api

import com.polish.usedaggerhilt.data.POSTNetworkEntity
import retrofit2.http.GET

interface PostAPI {

    @GET("posts")
    suspend fun getPosts():List<POSTNetworkEntity>

}