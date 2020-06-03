package com.sun_asterisk.clean_architecture_sample.ui.movies

import androidx.lifecycle.Observer
import com.sun_asterisk.clean_architecture_sample.R
import com.sun_asterisk.clean_architecture_sample.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel

internal class MoviesFragment private constructor() : BaseFragment<MoviesViewModel>() {
    private val adapter = MovieAdapter()

    override val layoutResource = R.layout.fragment_movies

    override val viewModel: MoviesViewModel by viewModel()

    @ExperimentalCoroutinesApi
    override fun initComponents() {
        moviesRecyclerView.adapter = adapter
        viewModel.getMovies(getString(R.string.title_popular))
    }

    override fun observeData() = with(viewModel) {
        viewModel.messageToast.observe(viewLifecycleOwner, Observer(::toast))
        movies.observe(viewLifecycleOwner, Observer(adapter::submitList))
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }
}
