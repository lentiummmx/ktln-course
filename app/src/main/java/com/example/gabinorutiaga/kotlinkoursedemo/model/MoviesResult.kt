package com.example.gabinorutiaga.kotlinkoursedemo.model

sealed class MoviesResult {
    object Loading : MoviesResult()
    data class Success(val movies: ArrayList<Movie>) : MoviesResult()
    object Error : MoviesResult()
}