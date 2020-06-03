package com.sun_asterisk.clean_architecture_sample.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun_asterisk.clean_architecture_sample.model.MovieModel
import com.sun_asterisk.clean_architecture_sample.model.mapper.MovieModelMapper
import com.sun_asterisk.clean_architecture_sample.ui.base.BaseViewModel
import com.sun_asterisk.domain.entity.Movie
import com.sun_asterisk.domain.usecase.GetMoviesUseCase
import com.sun_asterisk.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi

internal class MoviesViewModel(
    private val useCase: GetMoviesUseCase,
    private val movieModelMapper: MovieModelMapper
) : BaseViewModel() {
    private val _movies = MutableLiveData<List<MovieModel>>()
    val movies: LiveData<List<MovieModel>> get() = _movies

    private val _messageToast = MutableLiveData<String>()
    val messageToast: LiveData<String> get() = _messageToast

    @ExperimentalCoroutinesApi
    fun getMovies(category: String) =
        useCase.invoke(category, object : UseCaseResponse<List<Movie>> {
            override fun onSuccess(result: List<Movie>) {
                _movies.value = result.map {
                    movieModelMapper.map(it)
                }
            }

            override fun onError(errorMsg: String?) {
                _messageToast.value = errorMsg
            }
        })
}
