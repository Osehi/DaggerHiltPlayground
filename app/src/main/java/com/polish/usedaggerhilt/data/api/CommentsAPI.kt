package com.polish.usedaggerhilt.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface CommentsAPI {
    @GET("posts/{id}/comments")
    suspend fun getComments(
        @Path("id") postId:Int
    ):List<Any>
}