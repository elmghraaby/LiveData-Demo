package com.example.applicationlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationlivedata.data.modules.PostModel
import com.example.applicationlivedata.data.repo.PostRepository

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()

        val postViewModelFactory = PostViewModelFactory(PostRepository())

        postViewModel = ViewModelProvider(this, postViewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postData.observe(this, Observer {
            postAdapter.setPostData(it as ArrayList<PostModel>)
            findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        })
    }

    private fun initUi() {
        recyclerView = findViewById(R.id.recyclerView)
        postAdapter = PostAdapter(ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }

}