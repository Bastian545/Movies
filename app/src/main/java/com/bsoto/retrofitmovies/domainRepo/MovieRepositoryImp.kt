package com.bsoto.retrofitmovies.domainRepo

import com.bsoto.retrofitmovies.data.local.LocalMovieDataSource
import com.bsoto.retrofitmovies.data.model.MovieList
import com.bsoto.retrofitmovies.data.model.toMovieEntity
import com.bsoto.retrofitmovies.data.remote.RemoteMovieDataSource

class MovieRepositoryImp(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList {
        dataSourceRemote.getUpcomingMovies().results.forEach{
            dataSourceLocal.saveMovie(it.toMovieEntity("upcoming"))
        }
        return dataSourceLocal.getUpcomingMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList {
        dataSourceRemote.getTopRatedMovies().results.forEach{
            dataSourceLocal.saveMovie(it.toMovieEntity("toprated"))
        }
        return dataSourceLocal.getTopRatedMovies()
    }

    override suspend fun getPopularMovies(): MovieList {
         dataSourceRemote.getPopularMovies().results.forEach{
            dataSourceLocal.saveMovie(it.toMovieEntity("popular"))
        }
        return dataSourceLocal.getPopularMovies()
    }
}