package com.hasanshukurov.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hasanshukurov.movieapp.data.movie.TvShowItem
import com.hasanshukurov.movieapp.databinding.MovieRowBinding
import com.hasanshukurov.movieapp.view.TvShowFragmentDirections
import com.squareup.picasso.Picasso
import javax.inject.Inject

class MovieAdapter(var movieList: List<TvShowItem>): RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    class MovieHolder(val binding:MovieRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = MovieRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val currenPosition = movieList[position]

        Picasso.get().load(currenPosition.image.original).into(holder.binding.imageViewMovie)
        holder.binding.textViewMovie.text = currenPosition.name
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(TvShowFragmentDirections.actionTvShowFragmentToTvShowDetailFragment(movieDetailIdArgs = currenPosition))
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}