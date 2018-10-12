package com.example.gabinorutiaga.kotlinkoursedemo.background.ws

import com.example.gabinorutiaga.kotlinkoursedemo.model.movie.Movie
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface ApiDefinition {

    @GET("/movies")
    fun movies(): Call<ArrayList<Movie>>

    @GET("/movies")
    fun movies2(): Deferred<ArrayList<Movie>>

    /*--
    @POST("/login")
    // @Multipart
    fun login(loginRequest: Any): Call<Any>
    --*/
}