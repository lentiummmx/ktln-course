package com.example.gabinorutiaga.kotlinkoursedemo.model.movie

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface MovieDAO {

    @Query("SELECT * FROM movie")
    fun movies(): List<Movie>

    @Query("DELETE from movie")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(movie: Movie)

}