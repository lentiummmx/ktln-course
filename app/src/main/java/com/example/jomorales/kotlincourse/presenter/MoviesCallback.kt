package com.example.jomorales.kotlincourse.presenter

import com.example.jomorales.kotlincourse.model.MoviesResult

interface MoviesCallback {
    fun onViewStateChanged(moviesResult: MoviesResult)
}