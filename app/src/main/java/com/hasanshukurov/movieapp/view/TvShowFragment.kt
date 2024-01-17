package com.hasanshukurov.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.hasanshukurov.movieapp.adapter.ActorAdapter
import com.hasanshukurov.movieapp.adapter.EpisodeAdapter
import com.hasanshukurov.movieapp.adapter.MovieAdapter
import com.hasanshukurov.movieapp.databinding.FragmentTvShowBinding
import com.hasanshukurov.movieapp.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private val binding: FragmentTvShowBinding get() = _binding!!
    private lateinit var viewModel: TvShowViewModel
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var actorAdapter: ActorAdapter
    private lateinit var episodeAdapter: EpisodeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            viewModel.tvShowList.observe(viewLifecycleOwner){

                movieAdapter = MovieAdapter(it)
                binding.recyclerView.adapter = movieAdapter
                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

            }

        viewModel.getAllTvShowVM()



            viewModel.actorList.observe(viewLifecycleOwner){

                actorAdapter = ActorAdapter(it)
                binding.rvActors.adapter = actorAdapter
                binding.rvActors.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

            }

        viewModel.getAllActorsVM()



            viewModel.episodeList.observe(viewLifecycleOwner){

                episodeAdapter = EpisodeAdapter(it)
                binding.rvRecentlyAdded.adapter = episodeAdapter
                binding.rvRecentlyAdded.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

            }

        viewModel.getAllEpisodeVM()


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}