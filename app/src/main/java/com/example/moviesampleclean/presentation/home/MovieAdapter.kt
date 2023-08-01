package com.example.moviesampleclean.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.moviesampleclean.data.movie.model.Data
import com.example.moviesampleclean.databinding.ItemMovieBinding
import javax.inject.Inject

class MovieAdapter(val glide : RequestManager) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movies = ArrayList<Data>()
        set(value) {
            movies.run {
                clear()
                movies.addAll(value)
                notifyDataSetChanged()
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        return holder.bindMovie(movies[position])
    }


    inner class MovieViewHolder(val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindMovie(movie: Data) {
            binding.tvItemMovieTitle.text = movie.title
            binding.tvItemMovieCountry.text = movie.genres.get(0)
            glide.load(movie.poster).into(binding.ivItemMovie)
        }


    }


}