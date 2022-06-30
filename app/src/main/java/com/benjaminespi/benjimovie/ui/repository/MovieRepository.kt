package com.benjaminespi.benjimovie.ui.repository

import com.benjaminespi.benjimovie.ui.data.model.MovieList

interface MovieRepository {
    suspend fun getPlayingNowMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}