package com.miaki.pocketguard.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.miaki.pocketguard.components.NetworkImage
import com.miaki.pocketguard.view_model.PostViewModel

@Composable
fun PostView(navController: NavController) {
    val viewModel: PostViewModel = hiltViewModel()
    val posts by viewModel.posts.collectAsState()
    val context = LocalContext.current;

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .padding(it)) {
            LazyColumn(modifier = Modifier.padding(horizontal = 10.dp)) {
                items(posts) { post ->
                    Card(modifier = Modifier.fillParentMaxWidth().padding(bottom = 10.dp)) {
                        Row(modifier = Modifier.padding(5.dp)) {
                            NetworkImage(context = context, imageUrl = post.thumbnailUrl,
                               modifier = Modifier.clip(shape = CircleShape).size(50.dp),
                               contentDescription = post.id.toString())
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(post.title)
                        }
                    }
                }
            }
        }
    }
}