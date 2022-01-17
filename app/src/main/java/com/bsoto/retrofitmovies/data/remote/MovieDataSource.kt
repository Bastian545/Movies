package com.bsoto.retrofitmovies.data.remote

import com.bsoto.retrofitmovies.data.model.MovieList
import com.bsoto.retrofitmovies.domainRepo.WebService
import com.bsoto.retrofitmovies.utils.AppConstants

class MovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): MovieList = webService.getUpcomingMovies(AppConstants.API_KEY)

    suspend fun getTopRatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)

}