package com.example.gabinorutiaga.kotlinkoursedemo.presenter

import com.example.gabinorutiaga.kotlinkoursedemo.background.ws.MoviesApi
import com.example.gabinorutiaga.kotlinkoursedemo.model.MoviesDatabase
import com.example.gabinorutiaga.kotlinkoursedemo.model.movie.Movie
import com.example.gabinorutiaga.kotlinkoursedemo.model.MoviesResult
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesPresenter(private val callback: MoviesCallback) {

    private var call : Call<ArrayList<Movie>> ? = null
    private val db = MoviesDatabase.getInstance()

    fun fetchMovies() {
        val localMovies = db?.movieDAO()?.movies() as ArrayList<Movie>
        if (localMovies.size == 0) {
            callback.onViewStateChanged(MoviesResult.Loading)
        } else {
            callback.onViewStateChanged(MoviesResult.Success(localMovies))
        }

        // callback.onViewStateChanged(MoviesResult.Loading)
        /*--
        Handler().postDelayed(
                {
                    callback.onViewStateChanged(MoviesResult.Success(createDummyMovies()))
                },
                5000 // value in milliseconds
        )
        --*/

        // val call = MoviesApi.api.movies()
        call = MoviesApi.api.movies()
        // call.execute()  // synch
        call?.enqueue(object: Callback<ArrayList<Movie>> {
            override fun onFailure(call: Call<ArrayList<Movie>>, t: Throwable) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                callback.onViewStateChanged(MoviesResult.Error)
            }

            override fun onResponse(call: Call<ArrayList<Movie>>, response: Response<ArrayList<Movie>>) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                if (response.isSuccessful) {
                    val movies = response.body() ?: arrayListOf()
                    // val movie = movies?.get(0)
                    movies.size > 0.apply {
                        db?.movieDAO()?.deleteAll()
                        movies.forEach {
                            db?.movieDAO()?.insertOrUpdate(it)
                        }
                    }
                    callback.onViewStateChanged(MoviesResult.Success(movies))
                }
            }
        }) // asynch
    }

    private var job: Job? = null
    fun fetchMovies2() {
        job = launch {
            val localMovies = db?.movieDAO()?.movies() as ArrayList<Movie>
            withContext(UI) {
                if (localMovies.size == 0) {
                    callback.onViewStateChanged(MoviesResult.Loading)
                } else {
                    callback.onViewStateChanged(MoviesResult.Success(localMovies))
                }
            }
            try {
                val movies = MoviesApi.api.movies2().await()
                movies.size > 0.apply {
                    db?.movieDAO()?.deleteAll()
                    movies.forEach {
                        db?.movieDAO()?.insertOrUpdate(it)
                    }
                }
                withContext(UI) {
                    callback.onViewStateChanged(MoviesResult.Success(movies))
                }
            } catch (ex: Exception) {
                withContext(UI) {
                    callback.onViewStateChanged(MoviesResult.Error)
                    callback.onViewStateChanged(MoviesResult.Success(localMovies))
                }
            }
        }
    }

    fun onDestroy() {
        call?.isExecuted.apply {
            call?.cancel()
        }
        job?.cancel()
    }

    /*--
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
    --*/
}