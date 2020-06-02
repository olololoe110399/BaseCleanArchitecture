package com.sun_asterisk.domain.repository

import com.sun_asterisk.domain.entity.Movie

interface MoviesRepository {

    suspend fun getMovies(category: String): List<Movie>
}
