package com.benjaminespi.benjimovie.ui.domain

import com.benjaminespi.benjimovie.ui.data.model.MovieList
import com.benjaminespi.benjimovie.ui.repository.MovieRepository
import javax.inject.Inject

class GetPlayingNowMoviesUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(): MovieList = repository.getPlayingNowMovies()

}