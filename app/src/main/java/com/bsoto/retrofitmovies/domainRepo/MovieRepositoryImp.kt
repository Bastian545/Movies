package com.bsoto.retrofitmovies.domainRepo

import com.bsoto.retrofitmovies.data.model.MovieList
import com.bsoto.retrofitmovies.data.remote.MovieDataSource

class MovieRepositoryImp(private val dataSource: MovieDataSource): MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()
    //manera Kotlin
    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()
    //manera Normal
    override suspend fun getPopularMovies(): MovieList {
        return dataSource.getPopularMovies()
    }
}