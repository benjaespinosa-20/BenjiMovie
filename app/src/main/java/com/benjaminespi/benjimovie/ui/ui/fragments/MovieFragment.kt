package com.benjaminespi.benjimovie.ui.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.benjaminespi.benjimovie.R
import com.benjaminespi.benjimovie.databinding.FragmentMovieBinding
import com.benjaminespi.benjimovie.ui.utils.Resource
import com.benjaminespi.benjimovie.ui.data.model.Movie
import com.benjaminespi.benjimovie.ui.data.remote.MovieDataSource
import com.benjaminespi.benjimovie.ui.ui.viewmodel.MovieViewModel
import com.benjaminespi.benjimovie.ui.repository.MovieRepositoryImplement
import com.benjaminespi.benjimovie.ui.ui.adapter.MovieAdapter
import com.benjaminespi.benjimovie.ui.ui.adapter.PlayingNowConcatAdapter
import com.benjaminespi.benjimovie.ui.ui.adapter.PopularConcatAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieFragment: Fragment(R.layout.fragment_movie), MovieAdapter.OnMovieClickListener {
    private lateinit var binding: FragmentMovieBinding
    private val viewModel: MovieViewModel by viewModels()

    //inyeccion de dependencias manual
    /*private val viewModel by viewModels<MovieViewModel>{
        MovieViewModelFactory(MovieRepositoryImplement(
        MovieDataSource(RetrofitClient.webservice)
    ))
    }*/

    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentMovieBinding.bind(view)

        concatAdapter = ConcatAdapter()

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner) { result ->
            when(result){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(0, PlayingNowConcatAdapter(MovieAdapter(result.data.first.results, this@MovieFragment)))
                        addAdapter(1, PopularConcatAdapter(MovieAdapter(result.data.second.results, this@MovieFragment)))
                    }

                    binding.rvMovies.adapter = concatAdapter
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        }

    }

    override fun onMovieClick(movie: Movie) {
        val action = MovieFragmentDirections.actionMovieFragmentToDetailFragment(
            movie.poster_path, movie.backdrop_path, movie.vote_average.toFloat(), movie.vote_count, movie.overview,
            movie.title, movie.original_language, movie.release_date)

        findNavController().navigate(action)
    }

}