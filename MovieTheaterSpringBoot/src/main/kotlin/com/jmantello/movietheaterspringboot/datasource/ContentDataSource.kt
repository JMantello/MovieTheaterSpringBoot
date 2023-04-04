package com.jmantello.movietheaterspringboot.datasource

import com.jmantello.movietheaterspringboot.model.Content

interface ContentDataSource {

    fun retrieveContent(): Collection<Content>

}