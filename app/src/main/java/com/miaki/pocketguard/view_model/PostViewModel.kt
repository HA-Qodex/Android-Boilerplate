package com.miaki.pocketguard.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miaki.pocketguard.model.PostModel
import com.miaki.pocketguard.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    val posts:StateFlow<List<PostModel>> get() = postRepository.posts

    init {
        viewModelScope.launch {
            postRepository.fetchPosts()
        }
    }
}