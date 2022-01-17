package com.bsoto.retrofitmovies.domainRepo

import com.bsoto.retrofitmovies.data.model.MovieList

interface MovieRepository {
    suspend fun getUpcomingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}