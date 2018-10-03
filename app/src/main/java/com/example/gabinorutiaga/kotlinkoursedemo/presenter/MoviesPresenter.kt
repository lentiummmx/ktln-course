package com.example.gabinorutiaga.kotlinkoursedemo.presenter

import android.os.Handler
import com.example.gabinorutiaga.kotlinkoursedemo.model.Movie

class MoviesPresenter(private val callback: MoviesCallback)  {

    fun fetchMovies(){
        callback.onLoadingMovies()
        Handler().postDelayed(
                {
                    callback.onSuccessMovies(createDummyMovies())
                },
                5000 // value in milliseconds
        )
    }

    private fun createDummyMovies(): ArrayList<Movie> {
        val result: ArrayList<Movie> = arrayListOf()

        result.add(Movie(1, "The Grinch", "The famous christmas movie", "AA", 5, "https://upload.wikimedia.org/wikipedia/en/e/e7/How_the_Grinch_Stole_Christmas_film_poster.jpg"))
        result.add(Movie(2, "Twilight", "That movie with the vampire guy ant the werewolf guy", "A", 3, "https://upload.wikimedia.org/wikipedia/en/thumb/b/b6/Twilight_%282008_film%29_poster.jpg/220px-Twilight_%282008_film%29_poster.jpg"))
        result.add(Movie(3, "Pokemon", "The great pokemon movie", "AA", 5, "https://m.media-amazon.com/images/M/MV5BN2NkZjA0OWUtZDgyMy00MjIxLWJhZTEtYjdmYzVjZTQ3YWRiL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMzM4MjM0Nzg@._V1_.jpg"))
        result.add(Movie(4, "The Incredibles", "A family with super powers lives hidden in a society that don't accept them", "AA", 4, "https://images-na.ssl-images-amazon.com/images/I/81bwO3261WL._SY445_.jpg"))
        result.add(Movie(5, "Zootopia", "Judy Hopps becomes a police officer and recruits Nick Wilde to help her solve the disappearing of an otter.", "AA", 5, "https://lumiere-a.akamaihd.net/v1/images/movie_poster_zootopia_866a1bf2.jpeg?region=0%2C0%2C300%2C450"))
        result.add(Movie(6, null, "The famous christmas movie", "AA", 5, "https://upload.wikimedia.org/wikipedia/en/e/e7/How_the_Grinch_Stole_Christmas_film_poster.jpg"))
        result.add(Movie(7, "Twilight", null, "A", 3, "https://upload.wikimedia.org/wikipedia/en/thumb/b/b6/Twilight_%282008_film%29_poster.jpg/220px-Twilight_%282008_film%29_poster.jpg"))
        result.add(Movie(8, "Pokemon", "The great pokemon movie", "AA", 0, "https://m.media-amazon.com/images/M/MV5BN2NkZjA0OWUtZDgyMy00MjIxLWJhZTEtYjdmYzVjZTQ3YWRiL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMzM4MjM0Nzg@._V1_.jpg"))
        result.add(Movie(9, "The Incredibles", "A family with super powers lives hidden in a society that don't accept them", "AA", 4, null))
        result.add(Movie(null, null, null, null, null, null))

        return result
    }

}