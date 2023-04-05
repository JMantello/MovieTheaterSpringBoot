package com.jmantello.movietheaterspringboot.service

import com.jmantello.movietheaterspringboot.datasource.ContentDataSource
import com.jmantello.movietheaterspringboot.model.Content
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class ContentService(@Qualifier("Mock") private val dataSource: ContentDataSource) {

    fun getContent(): Collection<Content> = dataSource.retrieveContent()
    fun getContent(contentId: Int): Content = dataSource.retrieveContent(contentId)
    fun addContent(content: Content) = dataSource.createContent(content)
    fun updateContent(contentId: Int, content: Content) = dataSource.updateContent(contentId, content)
    fun deleteContent(contentId: Int) = dataSource.deleteContent(contentId)
}