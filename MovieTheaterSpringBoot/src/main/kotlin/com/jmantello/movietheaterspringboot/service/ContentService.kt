package com.jmantello.movietheaterspringboot.service

import com.jmantello.movietheaterspringboot.datasource.ContentDataSource
import com.jmantello.movietheaterspringboot.model.Content
import org.springframework.stereotype.Service

@Service
class ContentService(private val dataSource: ContentDataSource) {

    fun getContent(): Collection<Content> = dataSource.retrieveContent()
    fun getContent(contentId: Int): Content = dataSource.retrieveContent(contentId)
    fun addContent(content: Content) = dataSource.createContent(content)
}