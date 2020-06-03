package com.sun_asterisk.clean_architecture_sample.model.mapper

import com.sun_asterisk.clean_architecture_sample.model.MovieModel
import com.sun_asterisk.domain.entity.Movie

class MovieModelMapper : PresentationMapper<Movie, MovieModel>() {
    override fun map(entity: Movie): MovieModel {
        return MovieModel(
            entity.movieID,
            entity.movieTitle,
            entity.movieOverView,
            entity.moviePosterPath,
            entity.movieBackdropPath,
            entity.movieVoteAverage,
            entity.movieReleaseDate
        )
    }
}