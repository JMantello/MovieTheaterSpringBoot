package com.jmantello.movietheaterspringboot.datasource.mock

import com.jmantello.movietheaterspringboot.datasource.ContentDataSource
import com.jmantello.movietheaterspringboot.model.Content
import org.springframework.stereotype.Repository

@Repository
class MockContentDataSource : ContentDataSource {

    val content = listOf(
        Content("Title1", "Description1", "Genre1", "imageUrl1"),
        Content("Title2", "Description2", "Genre2", "imageUrl2"),
        Content("Title3", "Description3", "Genre3", "imageUrl3"),
    )

    override fun retrieveContent(): Collection<Content> = content
    override fun retrieveContent(contentId: Int): Content = content[contentId]
}