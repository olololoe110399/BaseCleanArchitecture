package com.sun_asterisk.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun_asterisk.domain.entity.MappableData
import com.sun_asterisk.domain.entity.Movie

data class MovieEntity(
    @SerializedName("id")
    @Expose
    val movieID: Int,
    @SerializedName("title")
    @Expose
    val movieTitle: String,
    @SerializedName("overview")
    @Expose
    val movieOverView: String,
    @SerializedName("poster_path")
    @Expose
    val moviePosterPath: String,
    @SerializedName("backdrop_path")
    @Expose
    val movieBackdropPath: String,
    @SerializedName("vote_average")
    @Expose
    val movieVoteAverage: Double,
    @SerializedName("release_date")
    @Expose
    val movieReleaseDate: String
) : MappableData<Movie> {

    override fun map() = Movie(
        movieID,
        movieTitle,
        movieOverView,
        moviePosterPath,
        movieBackdropPath,
        movieVoteAverage,
        movieReleaseDate
    )
}
