package com.jmantello.movietheaterspringboot.datasource

import com.jmantello.movietheaterspringboot.model.Movie

interface MovieDataSource {

    fun getTrending(): Collection<Movie>

}