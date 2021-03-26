package com.example.applicationlivedata.data.network

import com.example.applicationlivedata.data.api.PostsWebservice
import com.example.applicationlivedata.data.api.Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Url.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val postsWebservice: PostsWebservice by lazy {
        retrofit.create(PostsWebservice::class.java)
    }
}