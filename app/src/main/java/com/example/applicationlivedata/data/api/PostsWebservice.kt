package com.example.applicationlivedata.data.api

import com.example.applicationlivedata.data.modules.PostModel
import retrofit2.http.GET

interface PostsWebservice {

    @GET("posts")
    suspend fun getPost(): List<PostModel>

}
