package com.simcodic.books.presentation.author.controller

import com.simcodic.books.domain.author.data.Author
import com.simcodic.books.domain.author.service.AuthorService
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class AuthorControllerTest {

    private val authorService: AuthorService = mock()
    private val controller = AuthorController(authorService)

    private val id = "1"
    private val name = "Jhony"
    private val surname = "week"
    private val nationality = "USA"

    private val author = Author(id = id, name = name, surname = surname, nationality = nationality)

    @Test
    fun getAuthors_thenGetAuthorsFromService() {
        controller.getAuthors()

        verify(authorService).getAuthors()
    }

    @Test
    fun putAuthor_thenPutAuthorsInToService() {
        controller.putAuthor(author = author)

        verify(authorService).putAuthor(author)
    }

    @Test
    fun postAuthor_thenPostAuthorsInToService() {
        controller.postAuthor(author = author)

        verify(authorService).postAuthor(author)
    }

    @Test
    fun deleteAuthor_thenDeleteAuthorsInToService() {
        controller.deleteAuthor(id)

        verify(authorService).deleteAuthor(id)
    }
}