package com.jmantello.movietheaterspringboot.datasource.network

import com.jmantello.movietheaterspringboot.datasource.MovieDataSource
import com.jmantello.movietheaterspringboot.datasource.network.dto.MovieResults
import com.jmantello.movietheaterspringboot.model.Movie
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSource(
    @Autowired private val restTemplate: RestTemplate
) : MovieDataSource {

    @Value("\${apiKey}")
    private lateinit var apiKey: String

    override fun getTrending(): Collection<Movie> {
        val response: ResponseEntity<MovieResults> =
            restTemplate.getForEntity(
                "https://api.themoviedb.org/3/trending/movie/week?api_key=${apiKey}")

        return response.body?.results
            ?: throw IOException("Could not fetch movies from TMDb")
    }
}