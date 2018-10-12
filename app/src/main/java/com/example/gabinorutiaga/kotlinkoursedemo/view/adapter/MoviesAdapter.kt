package com.example.gabinorutiaga.kotlinkoursedemo.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.gabinorutiaga.kotlinkoursedemo.R
import com.example.gabinorutiaga.kotlinkoursedemo.model.movie.Movie
import com.bumptech.glide.request.RequestOptions


class MoviesAdapter(private var movies: ArrayList<Movie>, private val context: Context?) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private val requestOptions = RequestOptions()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_layout, parent, false)
        requestOptions.placeholder(R.drawable.placeholder_movie)
        requestOptions.error(R.drawable.placeholder_movie)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        //Load image
        context?.let {
            Glide.with(it)
                    .setDefaultRequestOptions(requestOptions)
                    .load(movie.image)
                    .into(holder.movieImage)
        }

        //Set title
        holder.movieTitle.text = movie.title ?: "(Title not available)"

        //Set description
        holder.movieDesc.text = movie.desc ?: "(Description not available)"

        //Set rating
        holder.movieRate.text = movie.rate ?: "Unknown"

        //Set stars
        var stars: String? = null

        movie.stars?.let {
            for (i in 0 until it) {
                if (stars == null) stars = ""
                stars += "★"
            }
        }
        holder.movieStars.text = stars ?: "Not rated"
    }

    fun update(movies: ArrayList<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage = itemView.findViewById<ImageView>(R.id.movie_image)
        val movieTitle = itemView.findViewById<TextView>(R.id.movie_title)
        val movieDesc = itemView.findViewById<TextView>(R.id.movie_desc)
        val movieRate = itemView.findViewById<TextView>(R.id.movie_rate)
        val movieStars = itemView.findViewById<TextView>(R.id.movie_stars)
    }
}