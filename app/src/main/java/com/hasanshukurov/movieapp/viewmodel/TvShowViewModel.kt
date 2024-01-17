package com.hasanshukurov.movieapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanshukurov.movieapp.data.actor.ActorResponse
import com.hasanshukurov.movieapp.data.episode.EpisodeResponse
import com.hasanshukurov.movieapp.data.movie.TvShowResponse
import com.hasanshukurov.movieapp.repo.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(val repo: TvShowRepository) : ViewModel() {

    val tvShowList = MutableLiveData<TvShowResponse>()
    val actorList = MutableLiveData<ActorResponse>()
    val episodeList = MutableLiveData<EpisodeResponse>()


    fun getAllTvShowVM() {
        viewModelScope.launch(Dispatchers.Main) {
            val response = repo.getAllTvShowRepo()

            if (response.isSuccessful) {
                response.body()?.let {
                    tvShowList.value = it
                }
            }
        }
    }


    fun getAllActorsVM() {
        viewModelScope.launch {
            val response = repo.getAllActorsRepo()

            if (response.isSuccessful) {
                response.body()?.let {
                    actorList.postValue(it)
                }
            }
        }
    }


    fun getAllEpisodeVM() {
        viewModelScope.launch(Dispatchers.Main) {
            val response = repo.getAllEpisodeRepo()

            if (response.isSuccessful) {
                response.body()?.let {
                    episodeList.value = it
                }
            }
        }
    }

}