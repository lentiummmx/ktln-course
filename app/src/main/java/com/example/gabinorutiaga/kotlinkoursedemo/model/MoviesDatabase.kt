package com.example.gabinorutiaga.kotlinkoursedemo.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.gabinorutiaga.kotlinkoursedemo.model.movie.Movie
import com.example.gabinorutiaga.kotlinkoursedemo.model.movie.MovieDAO
import com.example.gabinorutiaga.kotlinkoursedemo.view.App

@Database(
        entities = [Movie::class],
        version = 1
)
abstract class MoviesDatabase: RoomDatabase() {

    abstract fun movieDAO(): MovieDAO

    companion object {
        private var INSTANCE: MoviesDatabase? = null

        fun getInstance(context: Context = App.getContext()): MoviesDatabase? {
            if (INSTANCE == null) {
                synchronized(MoviesDatabase::class.java) {
                    INSTANCE = Room
                            .databaseBuilder(context, MoviesDatabase::class.java, "movies.db")
                            // .allowMainThreadQueries()
                            .build()
                }
            }

            return INSTANCE
        }
    }

}