package com.example.jomorales.kotlincourse.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.jomorales.kotlincourse.R
import com.example.jomorales.kotlincourse.model.Movie

class MoviesAdapter(private var movies: ArrayList<Movie>, private val context: Context?) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // val view: View! = LayoutInflater.from(p0.context).inflate(R.layout.movie_view, p0)
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.movie_view, p0, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val movie: Movie = movies.get(position)

        // Load image
        context?.let {
            Glide.with(it)
                    .load(movie.image)
                    .into(holder.movieImage);
        }

         holder.movieTitle.text = movie.title ?: "(Title not available)"
         // holder.movieTitle.text = movie.title
         holder.movieDesc.text = movie.desc
         holder.movieRate.text = movie.rate ?: "Not rated"

        var stars: String = ""
        movie.stars?.let {
            for (i: Int in 0 until movie.stars) {
                stars += "⭐"
            }
        }
         holder.movieStars.text = stars
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage = itemView.findViewById<ImageView>(R.id.movie_image)
        val movieTitle = itemView.findViewById<TextView>(R.id.movie_title)
        val movieDesc = itemView.findViewById<TextView>(R.id.movie_desc)
        val movieRate = itemView.findViewById<TextView>(R.id.movie_rate)
        val movieStars = itemView.findViewById<TextView>(R.id.movie_stars)
    }

    fun update(movies: ArrayList<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

}

