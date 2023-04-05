package com.jmantello.movietheaterspringboot.datasource.mock

import com.jmantello.movietheaterspringboot.datasource.ContentDataSource
import com.jmantello.movietheaterspringboot.model.Content
import org.springframework.stereotype.Repository


@Repository("mock")
class MockContentDataSource : ContentDataSource {

    val content = mutableListOf(
        Content("Title1", "Description1", "Genre1", "imageUrl1"),
        Content("Title2", "Description2", "Genre2", "imageUrl2"),
        Content("Title3", "Description3", "Genre3", "imageUrl3"),
    )

    fun contentExists(contentId: Int): Boolean {
        return !(contentId < 0 || contentId > content.size - 1)
    }

    override fun retrieveContent(): Collection<Content> = content
    override fun retrieveContent(contentId: Int): Content {
        if(!contentExists(contentId))
            throw NoSuchElementException("No content with that id")

        return content[contentId]
    }

    override fun createContent(content: Content): Content {
        this.content.add(content)
        return content
    }

    override fun updateContent(contentId: Int, content: Content): Content {
        if(!contentExists(contentId))
            throw NoSuchElementException("No content with that id")

        this.content[contentId] = content
        return content
    }

    override fun deleteContent(contentId: Int) {
        if(!contentExists(contentId))
            throw NoSuchElementException("No content with that id")

        content.removeAt(contentId)
    }
}