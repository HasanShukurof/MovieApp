package com.hasanshukurov.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.hasanshukurov.movieapp.R
import com.hasanshukurov.movieapp.databinding.FragmentTvShowDetailBinding
import com.hasanshukurov.movieapp.viewmodel.TvShowViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TvShowDetailFragment : Fragment() {

    private var _binding: FragmentTvShowDetailBinding? = null
    private val binding: FragmentTvShowDetailBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle: TvShowDetailFragmentArgs by navArgs()
        val gelenArgs = bundle.movieDetailIdArgs

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(gelenArgs.url)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}