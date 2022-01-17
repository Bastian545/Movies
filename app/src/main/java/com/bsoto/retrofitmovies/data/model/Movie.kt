package com.bsoto.retrofitmovies.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int = 0,
    val adult: Boolean = false,
   // val genre_ids: List<Int> = listOf(),
    val backdrop_path: String? = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String? = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0,
    val movie_type: String = ""

)

data class MovieList(val results: List<Movie> = listOf())

@Entity
data class MovieEntity(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo(name = "adult")
    val adult: Boolean = false,
    // esto no se usa y para no complicar con listas
    // val genre_ids: List<Int> = listOf(),
    val backdrop_path: String? = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String? = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0,
    @ColumnInfo(name = "movie_type")
    val movie_type: String = ""
)


fun List<MovieEntity>.toMovieList(): MovieList {
    val resultList = mutableListOf<Movie>()
    this.forEach {
        resultList.add(it.toMovie())
    }
    return MovieList(resultList)
}


fun MovieEntity.toMovie(): Movie =  Movie(
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_title,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    this.movie_type
)


fun Movie.toMovieEntity(movieType: String): MovieEntity = MovieEntity(
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_title,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    movie_type = movieType
)