package com.jmantello.movietheaterspringboot.datasource.network.dto

import com.jmantello.movietheaterspringboot.model.Movie

class MovieResults(
    val results: Collection<Movie>
)