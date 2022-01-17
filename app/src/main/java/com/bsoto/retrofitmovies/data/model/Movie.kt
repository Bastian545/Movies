package com.bsoto.retrofitmovies.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int = 0,
    val adult: Boolean = false,
    val genre_ids: List<Int> = listOf(),
    val backdrop_path: String? = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String= "",
    val popularity: Double = 0.0,
    val poster_path: String? = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double  = 0.0,
    val vote_count: Int = 0
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
    val overview: String= "",
    val popularity: Double = 0.0,
    val poster_path: String? = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double  = 0.0,
    val vote_count: Int = 0
)
