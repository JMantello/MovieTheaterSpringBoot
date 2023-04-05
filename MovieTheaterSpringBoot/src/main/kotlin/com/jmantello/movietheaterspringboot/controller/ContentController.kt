package com.jmantello.movietheaterspringboot.controller

import com.jmantello.movietheaterspringboot.model.Content
import com.jmantello.movietheaterspringboot.service.ContentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/content")
class ContentController(private val service: ContentService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping("all")
    fun getContent(): Collection<Content> = service.getContent()

    @GetMapping("/{contentId}")
    fun getContent(@PathVariable contentId: Int): Content = service.getContent(contentId)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addContent(@RequestBody content: Content): Content {
        service.addContent(content)
        return content
    }
}