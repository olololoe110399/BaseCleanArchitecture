package com.sun_asterisk.data.repository.source.remote.api

import com.sun_asterisk.data.repository.source.remote.api.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("movie/{category}")
    suspend fun getMovies(
        @Path("category") category: String
    ): MoviesResponse
}
