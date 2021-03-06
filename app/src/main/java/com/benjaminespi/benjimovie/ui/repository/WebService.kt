package com.benjaminespi.benjimovie.ui.repository

import android.provider.SyncStateContract
import com.benjaminespi.benjimovie.ui.data.model.MovieList
import com.benjaminespi.benjimovie.ui.utils.AppConstants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("movie/now_playing")
    suspend fun getPlayingNowMovies(@Query ("api_key") apiKey: String): MovieList
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query ("api_key") apiKey: String): MovieList
}

object RetrofitClient{

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}