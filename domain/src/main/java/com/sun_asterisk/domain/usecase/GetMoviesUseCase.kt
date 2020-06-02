package com.sun_asterisk.domain.usecase

import com.sun_asterisk.domain.entity.Movie
import com.sun_asterisk.domain.repository.MoviesRepository
import com.sun_asterisk.domain.usecase.base.UseCase

class GetMoviesUseCase constructor(
    private val moviesRepository: MoviesRepository
) : UseCase<List<Movie>, String>() {

    override suspend fun run(params: String): List<Movie> {
        return moviesRepository.getMovies(params)
    }
}
