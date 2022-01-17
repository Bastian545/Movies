package com.bsoto.retrofitmovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.bsoto.retrofitmovies.core.Resource
import com.bsoto.retrofitmovies.domainRepo.MovieRepository
import kotlinx.coroutines.Dispatchers


class MovieViewModel(private val repo: MovieRepository) : ViewModel() {


    //Crear una sola llamada para todas las peliculas
    fun fetchMainScreenMovies() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success((Triple(repo.getUpcomingMovies(),repo.getTopRatedMovies(),repo.getPopularMovies()))))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }




}

class MovieViewModelFactory(private val repo: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }


}

//Para reemplazar el TripleCall con una cantidad N
data class NTuple4<T1, T2, T3, T4>(val t1: T1, val t2: T2, val t3: T3, val t4: T4)



























//Crear Tres llamadas una para cada categoria

/*

fun fetchUpcomingMovies() = liveData(Dispatchers.IO) {
    emit(Resource.Loading())
    try {
        emit(Resource.Success(repo.getUpcomingMovies()))
    } catch (e: Exception) {
        emit(Resource.Failure(e))
    }
}

fun fetchTopRatedMovies() = liveData(Dispatchers.IO) {
    emit(Resource.Loading())
    try {
        emit(Resource.Success(repo.getTopRatedMovies()))
    } catch (e: Exception) {
        emit(Resource.Failure(e))
    }
}


fun fetchPopularMovies() = liveData(Dispatchers.IO) {
    emit(Resource.Loading())
    try {
        emit(Resource.Success(repo.getPopularMovies()))
    } catch (e: Exception) {
        emit(Resource.Failure(e))
    }
}*/
