package com.bsoto.retrofitmovies.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bsoto.retrofitmovies.core.BaseConcatHolder
import com.bsoto.retrofitmovies.databinding.PopularRowBinding
import com.bsoto.retrofitmovies.databinding.UpcomingRowBinding
import com.bsoto.retrofitmovies.ui.movie.adapters.MovieAdapter

class UpcomingConcatAdapter(private val moviesAdapter: MovieAdapter): RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = UpcomingRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when (holder){
            is ConcatViewHolder -> holder.bind(moviesAdapter)
        }
    }
    //SIEMPRE 1 EN LOS CONCAT
    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder (val binding: UpcomingRowBinding): BaseConcatHolder<MovieAdapter>(binding.root){
        override fun bind(adapter: MovieAdapter) {
            binding.rvUpcomingMovies.adapter = adapter
        }


    }

}