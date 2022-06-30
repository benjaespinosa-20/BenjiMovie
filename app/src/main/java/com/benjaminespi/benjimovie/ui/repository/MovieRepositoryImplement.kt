package com.benjaminespi.benjimovie.ui.repository

import com.benjaminespi.benjimovie.ui.data.model.MovieList
import com.benjaminespi.benjimovie.ui.data.remote.MovieDataSource

class MovieRepositoryImplement(private val dataSource: MovieDataSource): MovieRepository {
    override suspend fun getPlayingNowMovies(): MovieList = dataSource.getPlayingNowMovies()

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()

}