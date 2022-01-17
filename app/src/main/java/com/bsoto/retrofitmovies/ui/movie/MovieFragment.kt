package com.bsoto.retrofitmovies.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.bsoto.retrofitmovies.R
import com.bsoto.retrofitmovies.core.Resource
import com.bsoto.retrofitmovies.data.model.Movie
import com.bsoto.retrofitmovies.data.remote.RemoteMovieDataSource
import com.bsoto.retrofitmovies.databinding.FragmentMovieBinding
import com.bsoto.retrofitmovies.domainRepo.MovieRepositoryImp
import com.bsoto.retrofitmovies.domainRepo.RetrofitClient
import com.bsoto.retrofitmovies.presentation.MovieViewModel
import com.bsoto.retrofitmovies.presentation.MovieViewModelFactory
import com.bsoto.retrofitmovies.ui.movie.adapters.MovieAdapter
import com.bsoto.retrofitmovies.ui.movie.adapters.concat.PopularConcatAdapter
import com.bsoto.retrofitmovies.ui.movie.adapters.concat.TopRatedConcatAdapter
import com.bsoto.retrofitmovies.ui.movie.adapters.concat.UpcomingConcatAdapter


class MovieFragment : Fragment(R.layout.fragment_movie), MovieAdapter.OnMovieClickListener {
    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(
            MovieRepositoryImp(
                RemoteMovieDataSource(RetrofitClient.webservice)
            )
        )
    }

    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        concatAdapter = ConcatAdapter()


        //todas junto
        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, Observer {
            when (it) {

                is Resource.Loading -> {
                    binding.progressMovies.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressMovies.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(
                            0,
                            UpcomingConcatAdapter(
                                MovieAdapter(
                                    it.data.first.results,
                                    this@MovieFragment
                                )
                            )
                        )
                        addAdapter(
                            1,
                            TopRatedConcatAdapter(
                                MovieAdapter(
                                    it.data.second.results,
                                    this@MovieFragment
                                )
                            )
                        )
                        addAdapter(
                            2,
                            PopularConcatAdapter(
                                MovieAdapter(
                                    it.data.third.results,
                                    this@MovieFragment
                                )

                            )

                        )
                    }

                    binding.rvMovies.adapter = concatAdapter
                }
                is Resource.Failure -> {
                    binding.progressMovies.visibility = View.GONE
                    Log.d("LiveDataUpcoming", "${it.exception}")
                }
            }
        })
    }

    override fun onMovieClick(movie: Movie) {
        val action = MovieFragmentDirections.actionMovieFragmentToDetailsFragment(
            movie.poster_path,
            movie.backdrop_path,
            movie.vote_average.toFloat(),
            movie.vote_count,
            movie.overview,
            movie.title,
            movie.original_language,
            movie.release_date
        )
        findNavController().navigate(action)

    }
}


// Las tres llamadas por separado
/* viewModel.fetchUpcomingMovies().observe(viewLifecycleOwner, Observer {
    when(it){
        is Resource.Loading -> {
            Log.d("LiveDataUpcoming","Loading...")
        }
        is Resource.Success -> {
            Log.d("LiveDataUpcoming", "${it.data}")
        }
        is Resource.Failure -> {
            Log.d("LiveDataUpcoming","${it.exception}")
        }
    }
})

viewModel.fetchTopRatedMovies().observe(viewLifecycleOwner, Observer {
    when(it){
        is Resource.Loading -> {
            Log.d("LiveDataTopRated","Loading...")
        }
        is Resource.Success -> {
            Log.d("LiveDataTopRated", "${it.data}")
        }
        is Resource.Failure -> {
            Log.d("LiveDataTopRated","${it.exception}")
        }
    }

})

viewModel.fetchPopularMovies().observe(viewLifecycleOwner, Observer {
    when(it){
        is Resource.Loading -> {
            Log.d("LiveDataPopular","Loading...")
        }
        is Resource.Success -> {
            Log.d("LiveDataPopula", "${it.data}")
        }
        is Resource.Failure -> {
            Log.d("LiveDataPopula","${it.exception}")
        }
    }

}) */
