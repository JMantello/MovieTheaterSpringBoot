package com.jmantello.movietheaterspringboot.controller

import com.jmantello.movietheaterspringboot.model.Movie
import com.jmantello.movietheaterspringboot.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/movies")
class MovieController(private val service: MovieService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping("trending")
    fun getContent(): Collection<Movie> = service.getTrending()

    @GetMapping("/{contentId}")
    fun getContent(@PathVariable contentId: Int): String = "Getting ${contentId}"

}