package com.example.applicationlivedata.data.repo

import com.example.applicationlivedata.data.modules.PostModel
import com.example.applicationlivedata.data.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepository {

    fun getPost(): Flow<List<PostModel>> = flow {
        val postList = RetrofitBuilder.postsWebservice.getPost()
        emit(postList)
    }.flowOn(Dispatchers.IO)

}