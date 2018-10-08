package com.example.jomorales.kotlincourse.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.jomorales.kotlincourse.R

import com.example.jomorales.kotlincourse.model.MoviesResult
import com.example.jomorales.kotlincourse.presenter.MoviesCallback
import com.example.jomorales.kotlincourse.presenter.MoviesPresenter
import com.example.jomorales.kotlincourse.view.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_movies.*

/**
 * A simple [Fragment] subclass.
 *
 */
class MoviesFragment : Fragment(), MoviesCallback {

    private var presenter: MoviesPresenter? = null
    private var adapter: MoviesAdapter? = null

    override fun onViewStateChanged(moviesResult: MoviesResult) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when(moviesResult) {
            is MoviesResult.Loading -> {
                // LOADING
                Toast.makeText(context, "Loading movies... Please wait!", Toast.LENGTH_LONG).show()
            }
            is MoviesResult.Success -> {
                // SHOW MOVIES
                adapter?.update(moviesResult.movies)
            }
            is MoviesResult.Error -> {
                // APP DIES
                Toast.makeText(context, "Oh no!! :(", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MoviesAdapter(arrayListOf(), context)
        movies_container.adapter = adapter
        presenter = MoviesPresenter(this)
        presenter?.fetchMovies()
    }
}
