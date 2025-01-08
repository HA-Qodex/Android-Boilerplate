package com.miaki.pocketguard.repository

import android.util.Log
import com.miaki.pocketguard.model.PostModel
import com.miaki.pocketguard.route.ApiRoutes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiRoutes: ApiRoutes) {

    private val _posts = MutableStateFlow(emptyList<PostModel>())
    val posts: StateFlow<List<PostModel>> get() =  _posts

    suspend fun fetchPosts(){
        try {
            val response = apiRoutes.fetchPosts()
            if(response.isSuccessful && response.body() != null){
                _posts.emit(response.body()!!)
                Log.d("POST", "Status: ${response.code()}")
            }
        }catch (e:Exception){
            Log.d("POST", "fetchPosts: $e")
        }
    }
}