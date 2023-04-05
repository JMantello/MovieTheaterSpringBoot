package com.jmantello.movietheaterspringboot.datasource

import com.jmantello.movietheaterspringboot.model.Content

interface ContentDataSource {

    fun retrieveContent(): Collection<Content>
    fun retrieveContent(contentId: Int): Content
    fun createContent(content: Content): Content

}