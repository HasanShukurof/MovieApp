package com.hasanshukurov.movieapp.repo

import com.hasanshukurov.movieapp.data.actor.ActorResponse
import com.hasanshukurov.movieapp.data.episode.EpisodeResponse
import com.hasanshukurov.movieapp.data.movie.TvShowItem
import com.hasanshukurov.movieapp.data.movie.TvShowResponse
import com.hasanshukurov.movieapp.data.service.ApiInterface
import retrofit2.Response
import javax.inject.Inject

class TvShowRepository @Inject constructor(
    private val api: ApiInterface) {

    suspend fun getAllTvShowRepo() : Response<TvShowResponse> {
        return api.getAllTvShows()
    }

    suspend fun getAllActorsRepo() : Response<ActorResponse> {
        return api.getAllActors()
    }

    suspend fun getAllEpisodeRepo() : Response<EpisodeResponse> {
        return api.getAllEpisode()
    }

}