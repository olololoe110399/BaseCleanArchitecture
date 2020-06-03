package com.sun_asterisk.clean_architecture_sample.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.sun_asterisk.clean_architecture_sample.BR
import com.sun_asterisk.clean_architecture_sample.R
import com.sun_asterisk.clean_architecture_sample.databinding.ItemMovieBinding
import com.sun_asterisk.clean_architecture_sample.model.MovieModel
import com.sun_asterisk.shared.adapter.BaseRecyclerAdapter
import com.sun_asterisk.shared.adapter.BaseViewHolder

class MovieAdapter : BaseRecyclerAdapter<MovieModel, MovieAdapter.ViewHolder>(MovieDiffUtilCallback()) {
    var onItemClick: (MovieModel) -> Unit = { _ -> }

    override fun getItemViewType(position: Int) = R.layout.item_movie

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemMovieBinding>(layoutInflater, viewType, parent, false)
        return ViewHolder(binding, onItemClick)
    }

    class ViewHolder(
        private val binding: ViewDataBinding,
        private val onItemClick: (MovieModel) -> Unit
    ) : BaseViewHolder<MovieModel>(binding.root) {
        override fun onBindData(itemData: MovieModel) {
            super.onBindData(itemData)
            binding.setVariable(BR.movie, itemData)
            binding.executePendingBindings()
        }

        override fun onItemClickListener(itemData: MovieModel) = onItemClick(itemData)
    }

    class MovieDiffUtilCallback : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
            oldItem.movieID == newItem.movieID

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
            oldItem == newItem
    }
}
