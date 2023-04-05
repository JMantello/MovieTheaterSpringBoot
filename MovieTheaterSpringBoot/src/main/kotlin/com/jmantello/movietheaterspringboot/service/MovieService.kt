package com.jmantello.movietheaterspringboot.service

import com.jmantello.movietheaterspringboot.datasource.ContentDataSource
import com.jmantello.movietheaterspringboot.datasource.MovieDataSource
import com.jmantello.movietheaterspringboot.model.Content
import com.jmantello.movietheaterspringboot.model.Movie
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class MovieService(@Qualifier("network") private val dataSource: MovieDataSource) {

    fun getTrending(): Collection<Movie> = dataSource.getTrending()
}