package com.benjaminespi.benjimovie.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.benjaminespi.benjimovie.ui.utils.Resource
import com.benjaminespi.benjimovie.ui.repository.MovieRepository
import kotlinx.coroutines.Dispatchers

class MovieViewModel(private val repo: MovieRepository): ViewModel() {

    fun fetchMainScreenMovies() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(Resource.Success(Pair(repo.getPlayingNowMovies(), repo.getPopularMovies())))
        } catch(e: Exception){
            emit(Resource.Failure(e))
        }
    }

}

class MovieViewModelFactory(private val repo: MovieRepository): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }

}

