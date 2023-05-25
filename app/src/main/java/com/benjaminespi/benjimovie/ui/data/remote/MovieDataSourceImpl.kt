package com.benjaminespi.benjimovie.ui.data.remote

import com.benjaminespi.benjimovie.ui.data.model.MovieList
import com.benjaminespi.benjimovie.ui.repository.WebService
import com.benjaminespi.benjimovie.ui.utils.AppConstants
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(private val webService: WebService): MovieDataSource {

    override suspend fun getPlayingNowMovies(): MovieList = webService.getPlayingNowMovies(AppConstants.API_KEY)

    override suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)
}