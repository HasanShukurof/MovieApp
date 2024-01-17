package com.hasanshukurov.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hasanshukurov.movieapp.data.episode.EpisodeItem
import com.hasanshukurov.movieapp.data.movie.TvShowItem
import com.hasanshukurov.movieapp.databinding.EpisodeRowBinding
import com.hasanshukurov.movieapp.databinding.MovieRowBinding
import com.hasanshukurov.movieapp.view.TvShowFragmentDirections
import com.squareup.picasso.Picasso
import javax.inject.Inject

class EpisodeAdapter(var episodeList: List<EpisodeItem>): RecyclerView.Adapter<EpisodeAdapter.EpisodeHolder>() {
    class EpisodeHolder(val binding:EpisodeRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeHolder {
        val binding = EpisodeRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EpisodeHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeHolder, position: Int) {
        val currenPosition = episodeList[position]

        Picasso.get().load(currenPosition.image.original).into(holder.binding.imageViewEpisode)
        holder.binding.textViewEpisode.text = currenPosition.name



    }

    override fun getItemCount(): Int {
        return episodeList.size
    }


}