package com.example.gabinorutiaga.kotlinkoursedemo.presenter

import com.example.gabinorutiaga.kotlinkoursedemo.model.Movie

interface MoviesCallback {

    fun onLoadingMovies()

    fun onSuccessMovies(movies: ArrayList<Movie>)

    fun onErrorMovies()
}