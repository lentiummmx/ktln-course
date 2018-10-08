package com.example.jomorales.kotlincourse.model

sealed class MoviesResult {

    object Loading : MoviesResult()
    object Error : MoviesResult()
    data class Success (val movies: ArrayList<Movie>) : MoviesResult()

}