package com.miaki.pocketguard.components

import android.content.Context
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

//cacheDir.deleteRecursively() DELETE CACHE

const val cacheSize = (10 * 1024 * 1024).toLong() // 10 MB

fun okHttpClient(context: Context): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(offlineInterceptor(context))
        .addNetworkInterceptor(onlineInterceptor)
        .cache(Cache(context.cacheDir, cacheSize))
        .build()

val onlineInterceptor: Interceptor = Interceptor { chain ->
    val response: Response = chain.proceed(chain.request())
    val maxAge = 60 // read from cache for 60 seconds even if there is internet connection
    response.newBuilder()
        .header("Cache-Control", "public, max-age=$maxAge")
        .removeHeader("Pragma")
        .build()
}

fun offlineInterceptor(context: Context): Interceptor = Interceptor { chain ->
    var request = chain.request()
    if(!isInternetAvailable(context)){
        val maxStale = 60 * 60 * 24 * 30 // Offline cache available for 30 days
        request = request.newBuilder()
            .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
            .removeHeader("Pragma")
            .build();
    }
    chain.proceed(request)
}