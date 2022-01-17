package com.bsoto.retrofitmovies.domainRepo

import com.bsoto.retrofitmovies.data.model.MovieList
import com.bsoto.retrofitmovies.data.remote.RemoteMovieDataSource

class MovieRepositoryImp(private val dataSourceRemote: RemoteMovieDataSource): MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList = dataSourceRemote.getUpcomingMovies()
    //manera Kotlin
    override suspend fun getTopRatedMovies(): MovieList = dataSourceRemote.getTopRatedMovies()
    //manera Normal
    override suspend fun getPopularMovies(): MovieList {
        return dataSourceRemote.getPopularMovies()
    }
}