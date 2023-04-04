package com.jmantello.movietheaterspringboot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/content")
class ContentController {

    @GetMapping()
    fun getContent(): String {
        return "A content item"
    }
}