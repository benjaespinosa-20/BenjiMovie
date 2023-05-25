package com.benjaminespi.benjimovie.ui.data.remote

import com.benjaminespi.benjimovie.ui.data.model.MovieList
import com.benjaminespi.benjimovie.ui.repository.WebService
import com.benjaminespi.benjimovie.ui.utils.AppConstants
import javax.inject.Inject

interface MovieDataSource {
    suspend fun getPlayingNowMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}