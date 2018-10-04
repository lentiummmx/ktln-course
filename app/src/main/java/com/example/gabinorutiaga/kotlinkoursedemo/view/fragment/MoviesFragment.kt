package com.example.gabinorutiaga.kotlinkoursedemo.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.gabinorutiaga.kotlinkoursedemo.R
import com.example.gabinorutiaga.kotlinkoursedemo.model.MoviesResult
import com.example.gabinorutiaga.kotlinkoursedemo.presenter.MoviesCallback
import com.example.gabinorutiaga.kotlinkoursedemo.presenter.MoviesPresenter
import com.example.gabinorutiaga.kotlinkoursedemo.view.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_movies.*


class MoviesFragment : Fragment(), MoviesCallback {

    private var presenter: MoviesPresenter? = null
    private var adapter: MoviesAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MoviesAdapter(ArrayList(), context)
        presenter = MoviesPresenter(this)
        presenter?.fetchMovies()
        movies_container.adapter = adapter
    }

    override fun onViewStateChanged(moviesResult: MoviesResult) {
        when (moviesResult) {
            is MoviesResult.Loading -> {
                movies_container.visibility = View.GONE
                loading.visibility = View.VISIBLE
            }
            is MoviesResult.Success -> {
                adapter?.update(moviesResult.movies)
                movies_container.visibility = View.VISIBLE
                loading.visibility = View.GONE
            }
            is MoviesResult.Error -> {
                loading.visibility = View.GONE
                Toast.makeText(context, "Error loading movies", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
