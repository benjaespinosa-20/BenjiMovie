package com.benjaminespi.benjimovie.ui.data.remote

import com.benjaminespi.benjimovie.ui.data.model.MovieList
import com.benjaminespi.benjimovie.ui.repository.WebService
import com.benjaminespi.benjimovie.ui.utils.AppConstants

class MovieDataSource(private val webService: WebService) {

    suspend fun getPlayingNowMovies(): MovieList = webService.getPlayingNowMovies(AppConstants.API_KEY)


    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)
}