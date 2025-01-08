package com.miaki.pocketguard.route

import com.miaki.pocketguard.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiRoutes {

    @GET("photos")
    suspend fun fetchPosts(): Response<List<PostModel>>

}