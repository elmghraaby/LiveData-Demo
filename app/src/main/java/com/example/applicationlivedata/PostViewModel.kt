package com.example.applicationlivedata

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationlivedata.data.modules.PostModel
import com.example.applicationlivedata.data.repo.PostRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    val postData: MutableLiveData<List<PostModel>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            postRepository.getPost()
                .catch { e ->
                    Log.d("main", "getPost: ${e.message}")
                }
                .collect { postData1 ->
                    postData.value = postData1
                }
        }
    }


}