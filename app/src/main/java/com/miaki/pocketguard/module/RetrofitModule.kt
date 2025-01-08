package com.miaki.pocketguard.module

import android.content.Context
import com.miaki.pocketguard.components.okHttpClient
import com.miaki.pocketguard.route.ApiRoutes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient(context))
            .build()
    }

    @Provides
    @Singleton
    fun providesRoutes(@ApplicationContext context: Context): ApiRoutes{
        return provideRetrofit(context).create(ApiRoutes::class.java)

    }
}