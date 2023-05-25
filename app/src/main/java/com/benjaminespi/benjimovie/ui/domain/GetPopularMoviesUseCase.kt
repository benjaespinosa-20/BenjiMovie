package com.benjaminespi.benjimovie.ui.domain

import com.benjaminespi.benjimovie.ui.data.model.MovieList
import com.benjaminespi.benjimovie.ui.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repo: MovieRepository) {

    suspend operator fun invoke(): MovieList = repo.getPopularMovies()

}