package com.benjaminespi.benjimovie.ui.data.model

data class Movie(val id: Int = -1, val adult: Boolean, val genre_ids: List<Int> = listOf(), val backdrop_path: String = "",
                    val original_title: String = "", val original_language: String = "", val overview: String = "",
                    val popularity:String = "", val poster_path: String= "", val release_date: String= "", val title: String = "",
                    val video: Boolean = false, val vote_average: Double =-1.0, val vote_count: Int = -1)

data class MovieList(val results: List<Movie> = listOf())