package com.benjaminespi.benjimovie.ui.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.benjaminespi.benjimovie.ui.domain.GetPlayingNowMoviesUseCase
import com.benjaminespi.benjimovie.ui.domain.GetPopularMoviesUseCase
import com.benjaminespi.benjimovie.ui.utils.Resource
import com.benjaminespi.benjimovie.ui.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPlayingNowMoviesUseCase: GetPlayingNowMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel() {

    fun fetchMainScreenMovies() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(Resource.Success(Pair(getPlayingNowMoviesUseCase.invoke(), getPopularMoviesUseCase.invoke())))
        } catch(e: Exception){
            emit(Resource.Failure(e))
        }
    }

}

//patron de diseño factory
/*class MovieViewModelFactory(private val repo: MovieRepository): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }

}*/

