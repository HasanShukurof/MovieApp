package com.hasanshukurov.movieapp.di

import android.content.Context
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hasanshukurov.movieapp.R
import com.hasanshukurov.movieapp.data.service.ApiInterface
import com.hasanshukurov.movieapp.repo.TvShowRepository

import com.hasanshukurov.movieapp.util.Constant
import com.hasanshukurov.movieapp.util.Constant.BASE_URL_TvShows
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRetrofit() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_TvShows)
        .build()
        .create(ApiInterface::class.java)

    @Singleton
    @Provides
    fun injectRepo(api: ApiInterface) = TvShowRepository(api)


}














