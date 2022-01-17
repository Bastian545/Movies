package com.bsoto.retrofitmovies.ui.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bsoto.retrofitmovies.R
import com.bsoto.retrofitmovies.databinding.FragmentDetailsBinding
import com.bumptech.glide.Glide


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500${args.posterImageUrl}").centerCrop().into(binding.imgMovie)
        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500${args.backgroundImageUrl}").centerCrop().into(binding.imgBackground)
        binding.txtDescription.text = args.overview
        binding.txtTitle.text = args.title
        binding.txtLang.text = "Language ${args.language}"
        binding.txtRating.text = "${args.voteAverage} (${args.voteCount} Reviews)"
        binding.txtRelease.text = "Released ${args.releaseDate}"



    }

}