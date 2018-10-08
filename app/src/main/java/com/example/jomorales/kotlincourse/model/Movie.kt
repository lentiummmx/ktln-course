package com.example.jomorales.kotlincourse.model

data class Movie(val id: Int?,
                  // val title: String,
                  val title: String? = "Some Movie",
                  val desc: String?,
                  val rate: String?,
                  val stars: Int?,
                  val image: String?)