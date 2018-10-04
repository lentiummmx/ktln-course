package com.example.gabinorutiaga.kotlinkoursedemo.presenter

import com.example.gabinorutiaga.kotlinkoursedemo.model.MoviesResult

interface MoviesCallback {
    fun onViewStateChanged(moviesResult: MoviesResult)
}