package com.example.gabinorutiaga.kotlinkoursedemo.model.movie

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
        tableName = "movie"
)
data class Movie(
    @PrimaryKey
    val id: Long? = -1,
    @SerializedName("title1")
    val title: String?,
    @ColumnInfo(name = "description")
    val desc: String?,
    val rate: String?,
    val stars: Int?,
    val image: String?
)