package com.example.gabinorutiaga.kotlinkoursedemo.background.ws

import com.example.gabinorutiaga.kotlinkoursedemo.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesApi {

    val api: ApiDefinition = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiDefinition::class.java)

}