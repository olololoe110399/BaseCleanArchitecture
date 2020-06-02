package com.sun_asterisk.data.repository.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun_asterisk.data.model.MovieEntity

data class MoviesResponse(
    @SerializedName("results")
    @Expose
    val movies: List<MovieEntity>
)
