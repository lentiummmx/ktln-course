package com.example.gabinorutiaga.kotlinkoursedemo.model

import com.example.gabinorutiaga.kotlinkoursedemo.model.movie.Movie

sealed class MoviesResult {
    object Loading : MoviesResult()
    data class Success(val movies: ArrayList<Movie>) : MoviesResult()
    object Error : MoviesResult()
}