package com.jmantello.movietheaterspringboot.controller

import com.jmantello.movietheaterspringboot.model.Content
import com.jmantello.movietheaterspringboot.service.ContentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/content")
class ContentController(private val service: ContentService) {

    @GetMapping("all")
    fun getContent(): Collection<Content> {
        return service.getContent()
    }
}