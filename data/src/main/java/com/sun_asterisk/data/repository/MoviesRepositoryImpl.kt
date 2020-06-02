package com.sun_asterisk.data.repository

import com.sun_asterisk.data.model.MovieEntity
import com.sun_asterisk.data.repository.source.remote.api.MovieService
import com.sun_asterisk.domain.entity.Movie
import com.sun_asterisk.domain.repository.MoviesRepository

class MoviesRepositoryImpl(private val movieService: MovieService) : MoviesRepository {

    override suspend fun getMovies(category: String): List<Movie> {
        return movieService.getMovies(category).movies.map(MovieEntity::map)
    }
}
